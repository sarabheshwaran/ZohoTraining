package training.task11.helper;

import java.io.Serializable;

public class Dependant implements Serializable {

	public Dependant(int id, int employeeId, String dependantName, String relation, int age) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.dependantName = dependantName;
		this.relation = relation;
		this.age = age;
		
	}
	public Dependant() {
		// TODO Auto-generated constructor stub
	}
//	private static final long serialVersionUID = 1L;
	private int id;
	private int employeeId;
	private String dependantName;
	private String relation;
	private int age;
	public int a = 9;
	public int getId() {
		//cgjvhbknk
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getDependantName() {
		return dependantName;
	}
	public void setDependantName(String dependantName) {
		this.dependantName = dependantName;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Dependant [id=" + id + ",\n employeeId=" + employeeId + ",\n dependantName=" + dependantName + ",\n relation="
				+ relation + ",\n age=" + age + "]\n\n";
	}

	
	
	
}
