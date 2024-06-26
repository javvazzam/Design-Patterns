package factorymethod.factorymethod1.basic;
public class Main {
    public static void main(String[] args) {
        
        Car myCar = new Car("Toyota", "Corolla", 2022, "Red", 180, 4);
        System.out.println(myCar);
        myCar.accelerate();
        myCar.brake();
        myCar.drive();
        System.out.println(myCar);

        // Initialize a Truck
        Truck myTruck = new Truck("Volvo", "FH16", 2021, "White", 120, 20000);
        System.out.println(myTruck);
        myTruck.accelerate();
        myTruck.brake();
        myTruck.transport();
        System.out.println(myTruck);

        // Initialize a Ship
        Ship myShip = new Ship("Maersk", "Triple E", 2019, "Blue", 40, 20);
        System.out.println(myShip);
        myShip.accelerate();
        myShip.brake();
        myShip.sail();
        System.out.println(myShip);

    }
}