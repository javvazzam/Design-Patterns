package factorymethod.factorymethod1.chatgpt.run1;

interface TransportVehicle {
    void transport();
    void deliver();
}

class Ship implements TransportVehicle {
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
    
    @Override
    public void transport() {
        System.out.println("The ship " + getModel() + " is transporting. ");
    }

    @Override
    public void deliver() {
        System.out.println("The ship " + getModel() + " is delivering. ");
    }
}

class Truck implements TransportVehicle {
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
    
    @Override
    public void transport() {
        System.out.println("The truck " + getModel() + " is transporting. ");
    }

    @Override
    public void deliver() {
        System.out.println("The truck " + getModel() + " is delivering. ");
    }
}


public class Main {
    public static void main(String[] args) {
        Ship ship = new Ship("Hanse", 2022, 80);
        System.out.println(ship);

        Truck truck = new Truck("Volvo", 2021, 200);
        System.out.println(truck);

        transportAndDeliver(ship);
        transportAndDeliver(truck);
    }

    public static void transportAndDeliver(TransportVehicle vehicle) {
        vehicle.transport();
        vehicle.deliver();
    }
}

