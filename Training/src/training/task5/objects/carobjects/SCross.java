package training.task5.objects.carobjects;



public class SCross extends Car {
    private int seats;
    private int airbags;
    private String model;
    private String color;

    

    public SCross() {
        super("this is scross argument");
    }

    public void maintenance() {
        System.out.println("Maruti SCross under maintenance");
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getAirbags() {
        return airbags;
    }

    public void setAirbags(int airbags) {
        this.airbags = airbags;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
