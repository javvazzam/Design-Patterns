package factorymethod.factorymethod1.basic;

class Ship {
    private String model;
    private int year;
    private int maxSpeed;

    public Ship(String model, int year, int maxSpeed) {
        this.model = model;
        this.year = year;
        this.maxSpeed = maxSpeed;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public void transport() {
        System.out.println("The ship " + getModel() + " is transporting. ");
    }

    public void deliver() {
        System.out.println("The ship " + getModel() + " is delivering. ");
    }

    @Override
    public String toString() {
        return "Max Speed of the ship " + getModel() + " is " + getMaxSpeed();
    }
}
class Truck {
    private String model;
    private int year;
    private int maxSpeed;

    public Truck(String model, int year, int maxSpeed) {
        this.model = model;
        this.year = year;
        this.maxSpeed = maxSpeed;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public void transport() {
        System.out.println("The truck " + getModel() + " is transporting. ");
    }

    public void deliver() {
        System.out.println("The truck " + getModel() + " is delivering. ");
    }

    @Override
    public String toString() {
        return "Max Speed of the truck " + getModel() + " is " + getMaxSpeed();
    }
}

public class Main {
    public static void main(String[] args) {
        
        Ship ship = new Ship("Hanse", 2022, 80);
        System.out.println(ship);

        Truck truck = new Truck("Volvo", 2021, 200);
        System.out.println(truck);

        ship.transport();
        ship.deliver();

        truck.transport();
        truck.deliver();
    }
}