package factorymethod.factorymethod1.chatgpt;

public class Vehicle {
    private String brand;
    private String model;
    private int year;
    private String color;
    private int maxSpeed;

    public Vehicle(String brand, String model, int year, String color, int maxSpeed) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void accelerate() {
        System.out.println("The " + model + " is accelerating.");
    }

    public void brake() {
        System.out.println("The " + model + " is braking.");
    }

    @Override
    public String toString() {
        return "Brand: " + brand + ", Model: " + model + ", Year: " + year + ", Color: " + color + ", Max Speed: " + maxSpeed;
    }
}

