package factorymethod.factorymethod1.chatgpt;

public class ShipFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle(String brand, String model, int year, String color, int maxSpeed, int... additionalParams) {
        if (additionalParams.length < 1) {
            throw new IllegalArgumentException("Ship requires numberOfCabins parameter");
        }
        int numberOfCabins = additionalParams[0];
        return new Ship(brand, model, year, color, maxSpeed, numberOfCabins);
    }
}

