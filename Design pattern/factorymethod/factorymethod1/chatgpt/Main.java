package factorymethod.factorymethod1.chatgpt;

public class Main {
    public static void main(String[] args) {
        Vehicle car = VehicleFactoryRegistry.createVehicle("car", "Toyota", "Corolla", 2020, "Red", 180, 4);
        Vehicle ship = VehicleFactoryRegistry.createVehicle("ship", "Carnival", "Cruise", 2018, "White", 30, 150);
        Vehicle truck = VehicleFactoryRegistry.createVehicle("truck", "Volvo", "FH", 2022, "Blue", 120, 20000);

        System.out.println(car);
        System.out.println(ship);
        System.out.println(truck);

        // Registering and creating a new vehicle type dynamically
        VehicleFactoryRegistry.registerVehicleFactory("bike", new VehicleFactory() {
            @Override
            public Vehicle createVehicle(String brand, String model, int year, String color, int maxSpeed, int... additionalParams) {
                return new Vehicle(brand, model, year, color, maxSpeed) {
                    @Override
                    public String toString() {
                        return super.toString() + ", Type: Bike";
                    }
                };
            }
        });

        Vehicle bike = VehicleFactoryRegistry.createVehicle("bike", "Yamaha", "MT-07", 2021, "Black", 210);
        System.out.println(bike);
    }
}

