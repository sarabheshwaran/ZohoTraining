package training.task8.helper;

public class MyCustomClass {

	private String myText;
	
	

	public MyCustomClass() {
	}



	public MyCustomClass(String myText) {
		this.myText = myText;
	}



	@Override
	public String toString() {
		return "myText = " + myText;
	}
	
	
	
}
