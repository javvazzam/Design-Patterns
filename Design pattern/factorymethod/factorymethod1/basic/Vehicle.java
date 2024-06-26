package factorymethod.factorymethod1.basic;

public class Vehicle {
    // Vehicle properties
    private String brand;
    private String model;
    private int year;
    private String color;
    private int maxSpeed;

    // Constructor
    public Vehicle(String brand, String model, int year, String color, int maxSpeed) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    // Getters and setters
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

    // Method to accelerate
    public void accelerate() {
        System.out.println("The " + model + " is accelerating.");
    }

    // Method to brake
    public void brake() {
        System.out.println("The " + model + " is braking.");
    }
}

