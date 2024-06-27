package factorymethod.factorymethod1.chatgpt.run2;

class Vehicle {
    protected String model;
    protected int year;
    protected int maxSpeed;

    public Vehicle(String model, int year, int maxSpeed) {
        this.model = model;
        this.year = year;
        this.maxSpeed = maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void transport() {
        System.out.println("The vehicle " + getModel() + " is transporting. ");
    }

    public void deliver() {
        System.out.println("The vehicle " + getModel() + " is delivering. ");
    }

    @Override
    public String toString() {
        return "Max Speed of the vehicle " + getModel() + " is " + getMaxSpeed();
    }
}

class Ship extends Vehicle {
    public Ship(String model, int year, int maxSpeed) {
        super(model, year, maxSpeed);
    }
}

class Truck extends Vehicle {
    public Truck(String model, int year, int maxSpeed) {
        super(model, year, maxSpeed);
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle ship = new Ship("Hanse", 2022, 80);
        System.out.println(ship);

        Vehicle truck = new Truck("Volvo", 2021, 200);
        System.out.println(truck);

        ship.transport();
        ship.deliver();

        truck.transport();
        truck.deliver();
    }
}



