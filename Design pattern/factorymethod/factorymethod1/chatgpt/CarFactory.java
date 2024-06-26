package factorymethod.factorymethod1.chatgpt;

public class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle(String brand, String model, int year, String color, int maxSpeed, int... additionalParams) {
        if (additionalParams.length < 1) {
            throw new IllegalArgumentException("Car requires numberOfDoors parameter");
        }
        int numberOfDoors = additionalParams[0];
        return new Car(brand, model, year, color, maxSpeed, numberOfDoors);
    }
}

