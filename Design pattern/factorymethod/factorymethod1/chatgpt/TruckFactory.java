package factorymethod.factorymethod1.chatgpt;

public class TruckFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle(String brand, String model, int year, String color, int maxSpeed, int... additionalParams) {
        if (additionalParams.length < 1) {
            throw new IllegalArgumentException("Truck requires loadCapacityKg parameter");
        }
        int loadCapacityKg = additionalParams[0];
        return new Truck(brand, model, year, color, maxSpeed, loadCapacityKg);
    }
}

