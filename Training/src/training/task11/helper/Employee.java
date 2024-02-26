package training.task11.helper;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable{

	public static final long serialVersionUID = 1L;
	private int employeeId;
	private String employeeName;
	private String phoneNumber;
	private  String email;
	private String department;
	private List<Dependant> dependants ;
	
//	private Object readResolve() {
//        return "Hello";
//    }
	
	public void setDependants(List<Dependant> dependants) {
		this.dependants = dependants;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int i) {
		this.employeeId = i;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void addDependants(Dependant dependant) {
		this.dependants.add(dependant);
	}
	public void addDependants(List<Dependant> dependant) {
		this.dependants.addAll(dependant);
	}
	public void delDependants(Dependant dependant) {
		this.dependants.remove(dependant);
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", department=" + department + ",\n dependants : \n" + dependants + "]\n\n";
	}

	
}
