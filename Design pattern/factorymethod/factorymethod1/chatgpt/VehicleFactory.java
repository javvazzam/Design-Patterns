package factorymethod.factorymethod1.chatgpt;

public abstract class VehicleFactory {
    public abstract Vehicle createVehicle(String brand, String model, int year, String color, int maxSpeed, int... additionalParams);
}
