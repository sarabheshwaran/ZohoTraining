package training.task5.objects.carobjects;


public class Car {
    private int yearOfMake;
    private String engineNumber;
    private String type;
    

     public Car() {

    }

    public Car(int yearOfMake) {
		this.yearOfMake = yearOfMake;
	}

	public Car(String additionalInfo) {
    
	System.out.println(additionalInfo);
    }

    public void maintenance() {
        System.out.println("Car under maintenance");
    }
    public int getYearOfMake() {
        return yearOfMake;
    }

    public void setYearOfMake(int yearOfMake) {
        this.yearOfMake = yearOfMake;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	@Override
	public String toString() {
		return "Car [yearOfMake=" + yearOfMake + ", type=" + type + "]";
	}
    
    
}