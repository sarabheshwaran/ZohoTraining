package training.task8.helper;
public class Boy {

	private String name;
	private int age;
	
	
	
	public Boy() {
	}



	public Boy(String string, int integer) {
		this.name = string;
		this.age = integer;
	}



	public String getName() {
		return name;
	}



	public void setName(String string) {
		this.name = string;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int integer) {
		this.age = integer;
	}



	@Override
	public String toString() {
		return name + " - " + age ;
	}
	
	
	
}
