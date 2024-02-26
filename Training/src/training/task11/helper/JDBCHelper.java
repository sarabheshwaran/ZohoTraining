package training.task11.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import training.exceptions.CustomException;
import training.utilities.HelperUtils;

public class JDBCHelper {

	private Connection connection;

	QueryBuilder query = new QueryBuilder();

	private final StringBuilder updateQuery = new StringBuilder("UPDATE EMPLOYEE ");
	private final StringBuilder getEmpQuery = new StringBuilder("SELECT * FROM EMPLOYEE WHERE ");
	private final StringBuilder getDepQuery = new StringBuilder(
			"SELECT * FROM DEPENDANT JOIN EMPLOYEE ON DEPENDANT.E_ID = EMPLOYEE.ID WHERE ");

	private final String empInsertQuery = "INSERT INTO EMPLOYEE (NAME, PHONE, EMAIL, DEPARTMENT) VALUES(?,?,?,?)";
	private final String depInsertQuery = "INSERT INTO DEPENDANT (E_ID, NAME, AGE, RELATION) VALUES(?,?,?,?)";

	private final String EmployeeCreateQuery = "CREATE TABLE IF NOT EXISTS EMPLOYEE ( "
			+ "ID INT AUTO_INCREMENT PRIMARY KEY ," + "NAME varchar(50), " + "PHONE varchar(10), "
			+ "EMAIL varchar(50)," + " DEPARTMENT varchar(20));";

	private final String DependantCreateQuery = "CREATE TABLE IF NOT EXISTS DEPENDANT (D_ID INT AUTO_INCREMENT PRIMARY KEY, E_ID INT ,"
			+ "NAME VARCHAR(50), AGE INT(3), RELATION VARCHAR(10),"
			+ "FOREIGN KEY(E_ID) REFERENCES EMPLOYEE(ID) ON DELETE CASCADE );";

	private final String delQuery = "DELETE FROM EMPLOYEE WHERE ID = ? ";

	private final String depDelQuery = "DELETE FROM DEPENDANT WHERE D_ID = ?";

	public JDBCHelper(Connection connection) {
		this.connection = connection;
	}

	public int createEmpTable() throws CustomException {
		try (Statement statement = connection.createStatement()) {

			return statement.executeUpdate(EmployeeCreateQuery);

		} catch (SQLException e) {
			throw new CustomException("Table creation failed", e);
		}
	}

	public int createDependantTable() throws CustomException {
		try (Statement statement = connection.createStatement()) {

			return statement.executeUpdate(DependantCreateQuery);

		} catch (SQLException e) {
			throw new CustomException("Table creation failed", e);
		}
	}

	public void insertEmployees(List<Employee> employeeList) throws CustomException {

		HelperUtils.nullCheck(employeeList);

		try (PreparedStatement statement = connection.prepareStatement(empInsertQuery)) {

			for (Employee employee : employeeList) {

				statement.setString(1, employee.getEmployeeName());
				statement.setString(2, employee.getPhoneNumber());
				statement.setString(3, employee.getEmail());
				statement.setString(4, employee.getDepartment());
				statement.addBatch();
			}
			statement.executeBatch();

		} catch (SQLException e) {

			throw new CustomException("Statement creation error", e);
		}
	}

	public void insertDependant(List<Dependant> dependantList) throws CustomException {

		HelperUtils.nullCheck(dependantList);

		try (PreparedStatement statement = connection.prepareStatement(depInsertQuery)) {

			for (Dependant dependant : dependantList) {

				statement.setInt(1, dependant.getEmployeeId());
				statement.setString(2, dependant.getDependantName());
				statement.setInt(3, dependant.getAge());
				statement.setString(4, dependant.getRelation());
				statement.addBatch();
			}

			statement.executeBatch();
		} catch (SQLException e) {

			throw new CustomException("Statement creation error", e);
		}
	}

	public int update(List<String> fieldNames, List<String> values, int id) throws CustomException {

		int size = fieldNames.size();

		updateQuery.append("SET ");

		for (int i = 0; i < size; i++) {
			updateQuery.append(fieldNames.get(i) + " = ? ");
			if (i < size - 1) {
				updateQuery.append(" , ");
			}
		}

		String query = updateQuery.append("WHERE ID = ?").toString();

		try (PreparedStatement statement = connection.prepareStatement(query)) {

			for (int i = 1; i <= size; i++) {

				statement.setString(i, values.get(i - 1));

			}

			statement.setInt(size + 1, id);

			return statement.executeUpdate();

		} catch (SQLException e) {
			throw new CustomException("Updation error ! ", e);
		}

	}

	public List<Employee> getEmployees(String fieldName, String value, String orderBY, int limit)
			throws CustomException {

		getEmpQuery.append(fieldName + " = ?");
		if (limit > 0) {
			getEmpQuery.append("LIMIT " + limit);
		}
		if (orderBY != null) {
			getEmpQuery.append("ORDER BY " + orderBY);
		}

		String query = getEmpQuery.toString();

		try (PreparedStatement statement = connection.prepareStatement(query)) {

			if (fieldName.equals("ID")) {
				statement.setInt(1, Integer.parseInt(value));
			} else {
				statement.setString(1, value);
			}

			List<Employee> employeeList = new ArrayList<Employee>();

			try (ResultSet resultSet = statement.executeQuery()) {

				while (resultSet.next()) {

					Employee employee = mapEmployee(resultSet);

					employeeList.add(employee);
				}

				return employeeList;
			}
		} catch (SQLException e) {
			throw new CustomException("Statement creation error", e);
		}

	}

	public List<Employee> getDependants(String fieldName, String value) throws CustomException {

		getDepQuery.append("EMPLOYEE." + fieldName + " = ?");

		Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();

		try (PreparedStatement statement = connection.prepareStatement(getDepQuery.toString())) {

			statement.setString(1, value);

			try (ResultSet resultSet = statement.executeQuery()) {

				while (resultSet.next()) {

					Employee employee;
					Dependant dependant;

					int id = resultSet.getInt("ID");

					if (!employeeMap.containsKey(id)) {

						employee = mapEmployee(resultSet);
						employee.setDependants(new ArrayList<Dependant>());
						employeeMap.put(id, employee);

					}

					id = resultSet.getInt("E_ID");

					dependant = mapDependant(resultSet);
					employeeMap.get(id).addDependants(dependant);

				}
				return new ArrayList<Employee>(employeeMap.values());
			}
		} catch (SQLException e) {
			throw new CustomException("Statement creation error", e);
		}

	}

	public int deleteEmployee(String id) throws CustomException {

		try (PreparedStatement statement = connection.prepareStatement(delQuery)) {

			statement.setString(1, id);
			return statement.executeUpdate();

		} catch (SQLException e) {
			throw new CustomException("Statement creation error", e);
		}

	}

	public int deleteDependant(String id) throws CustomException {

		try (PreparedStatement statement = connection.prepareStatement(depDelQuery)) {

			statement.setString(1, id);
			return statement.executeUpdate();

		} catch (SQLException e) {
			throw new CustomException("Statement creation error", e);
		}

	}

	private Dependant mapDependant(ResultSet resultSet) throws SQLException {

		Dependant dependant = new Dependant();
		dependant.setId(resultSet.getInt("D_ID"));
		dependant.setEmployeeId(resultSet.getInt("E_ID"));
		dependant.setDependantName(resultSet.getString("DEPENDANT.NAME"));
		dependant.setAge(resultSet.getInt("AGE"));
		dependant.setRelation(resultSet.getString("RELATION"));

		return dependant;
	}

	private Employee mapEmployee(ResultSet resultSet) throws SQLException {
		Employee employee = new Employee();
		employee.setEmployeeId(resultSet.getInt("ID"));
		employee.setEmployeeName(resultSet.getString("EMPLOYEE.NAME"));
		employee.setPhoneNumber(resultSet.getString("PHONE"));
		employee.setEmail(resultSet.getString("EMAIL"));
		employee.setDepartment(resultSet.getString("DEPARTMENT"));
		return employee;
	}

}
