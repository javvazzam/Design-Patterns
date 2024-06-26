package factorymethod.factorymethod1.chatgpt;

public class Truck extends Vehicle {
    private int loadCapacityKg;

    public Truck(String brand, String model, int year, String color, int maxSpeed, int loadCapacityKg) {
        super(brand, model, year, color, maxSpeed);
        this.loadCapacityKg = loadCapacityKg;
    }

    public int getLoadCapacityKg() {
        return loadCapacityKg;
    }

    public void setLoadCapacityKg(int loadCapacityKg) {
        this.loadCapacityKg = loadCapacityKg;
    }

    public void transport() {
        System.out.println("The truck " + getModel() + " is transporting cargo.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Load Capacity: " + loadCapacityKg + " kg";
    }
}
