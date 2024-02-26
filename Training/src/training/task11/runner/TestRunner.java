package training.task11.runner;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import training.exceptions.CustomException;
import training.task11.helper.ConnectionManager;
import training.task11.helper.Employee;
import training.task11.helper.JDBCHelper;
import training.utilities.HelperUtils;

public class TestRunner {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			Logger logger = Logger.getGlobal();
			try {
				HelperUtils.formatLogger("4");
			
			
				logger.info("Enter Option :");

				int option = scanner.nextInt();

				scanner.nextLine();

				logger.info("-------------------------------------------------");

				Connection conn = ConnectionManager.getConnection();
				JDBCHelper jdbcHelper = new JDBCHelper(conn);
				switch (option) {
				case 1: {

					logger.info("Enter No of Employees to insert : ");
					int count = scanner.nextInt();
					scanner.nextLine();

					List<Employee> employeeList = new ArrayList<Employee>();
					for (int i = 0; i < count; i++) {

						Employee employee = new Employee();
						logger.info("Name : ");
						employee.setEmployeeName(scanner.nextLine());
						logger.info("Phone : ");
						employee.setPhoneNumber(scanner.nextLine());
						logger.info("Email : ");
						employee.setEmail(scanner.nextLine());
						logger.info("Department : ");
						employee.setDepartment(scanner.nextLine());
						employeeList.add(employee);

					}
					jdbcHelper.insertEmployees(employeeList);
					break;

				}
				case 2: {

					logger.info("Enter employee id to find : ");
					String id = scanner.nextLine();

					String orderBy = null;

					logger.info(jdbcHelper.getEmployees("ID",id,orderBy,0).toString());
					break;
				}
				case 3: {

					logger.info("Enter employee name to find : ");
					String name = scanner.nextLine();

					String orderBy = null;

					
					logger.info(jdbcHelper.getEmployees("NAME ",name,orderBy,0).toString());
					break;
				}

				case 4:

					logger.info("Enter employee id to update :");
					int ID = scanner.nextInt();
					scanner.nextLine();

//					logger.info("Enter the field to update :");
//					String field = scanner.nextLine();
//
//					logger.info("Enter the desired value :");
//					String value = scanner.nextLine();


					List<String> fields = List.of("NAME","PHONE");
					List<String> values = List.of("dorra","002321233");

					jdbcHelper.update(fields,values,ID);
					break;

				case 5: {

					logger.info("Enter no of rows to print :");

					scanner.nextLine();


					String orderBy = "NAME DESC";

					
					logger.info(jdbcHelper.getEmployees("","",orderBy,0).toString());
					break;
				}

				case 6: {

					logger.info("Enter ID to delete :");

					String id = scanner.nextLine();

					
					jdbcHelper.deleteEmployee(id);

				}
				case 7:{
					
					jdbcHelper.createDependantTable();
					break;
				}
				case 8:{
					logger.info(jdbcHelper.getDependants("NAME","John Doe").toString());
					break;
				}
				case 9: {
					
				}

				default: {
					logger.info("Invalid choice.");
					scanner.close();
					conn.close();
					break;
				}
				}

				logger.info("--------------------------------------------------");
			}

			catch (CustomException e) {
				logger.severe(e.getMessage() + "\n" + e.getCause().getMessage());

			} catch (Exception e) {
				logger.warning("Enter Correct Input : ");
				e.printStackTrace();
				scanner.nextLine();

			}
		}

	}

}
