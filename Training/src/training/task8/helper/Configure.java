package training.task8.helper;

public enum Configure {

	INSTANCE;
	
	private String specs ;
	
	public void setConfig(String specs) {
		
		this.specs = specs;
	}
	
	public void printConfig() {
		System.out.println("Enum configuration : "+ specs);
		
	}
	
}
