package factorymethod.factorymethod1.chatgpt;

public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, String model, int year, String color, int maxSpeed, int numberOfDoors) {
        super(brand, model, year, color, maxSpeed);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public void drive() {
        System.out.println("The car " + getModel() + " is driving.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Number of Doors: " + numberOfDoors;
    }
}

