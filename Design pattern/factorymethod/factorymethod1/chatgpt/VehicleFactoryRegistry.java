package factorymethod.factorymethod1.chatgpt;

import java.util.HashMap;
import java.util.Map;

public class VehicleFactoryRegistry {
    private static Map<String, VehicleFactory> registry = new HashMap<>();

    static {
        registry.put("car", new CarFactory());
        registry.put("ship", new ShipFactory());
        registry.put("truck", new TruckFactory());
    }

    public static void registerVehicleFactory(String vehicleType, VehicleFactory factory) {
        registry.put(vehicleType, factory);
    }

    public static Vehicle createVehicle(String vehicleType, String brand, String model, int year, String color, int maxSpeed, int... additionalParams) {
        VehicleFactory factory = registry.get(vehicleType.toLowerCase());
        if (factory == null) {
            throw new IllegalArgumentException("No factory registered for vehicle type: " + vehicleType);
        }
        return factory.createVehicle(brand, model, year, color, maxSpeed, additionalParams);
    }
}
