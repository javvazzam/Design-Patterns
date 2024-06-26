package factorymethod.factorymethod1.chatgpt;

public class Ship extends Vehicle {
    private int numberOfCabins;

    public Ship(String brand, String model, int year, String color, int maxSpeed, int numberOfCabins) {
        super(brand, model, year, color, maxSpeed);
        this.numberOfCabins = numberOfCabins;
    }

    public int getNumberOfCabins() {
        return numberOfCabins;
    }

    public void setNumberOfCabins(int numberOfCabins) {
        this.numberOfCabins = numberOfCabins;
    }

    public void sail() {
        System.out.println("The ship " + getModel() + " is sailing.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Number of Cabins: " + numberOfCabins;
    }
}

