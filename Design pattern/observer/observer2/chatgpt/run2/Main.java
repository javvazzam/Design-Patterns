package observer.observer2.chatgpt.run2;

import java.util.ArrayList;
import java.util.List;

interface TemperatureObserver {
    void onTemperatureChanged(float temperature);
}

class TemperatureDisplay implements TemperatureObserver {
    @Override
    public void onTemperatureChanged(float temperature) {
        System.out.println("La temperatura actual es: " + temperature + "°C");
    }
}

class TemperatureAlert implements TemperatureObserver {
    private float threshold;

    public TemperatureAlert(float threshold) {
        this.threshold = threshold;
    }

    @Override
    public void onTemperatureChanged(float temperature) {
        if (temperature > threshold) {
            System.out.println("¡Alerta! La temperatura ha superado el umbral: " + temperature + "°C");
        }
    }
}

class TemperatureSensor {
    private float temperature;
    private List<TemperatureObserver> observers = new ArrayList<>();

    public void addObserver(TemperatureObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TemperatureObserver observer) {
        observers.remove(observer);
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public float getTemperature() {
        return temperature;
    }

    private void notifyObservers() {
        for (TemperatureObserver observer : observers) {
            observer.onTemperatureChanged(temperature);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a TemperatureSensor object
        TemperatureSensor sensor = new TemperatureSensor();

        // Create and add a TemperatureDisplay observer
        TemperatureDisplay display = new TemperatureDisplay();
        sensor.addObserver(display);

        // Create and add a TemperatureAlert observer with a threshold of 30.0°C
        TemperatureAlert alert = new TemperatureAlert(30.0f);
        sensor.addObserver(alert);

        // Set the temperature to 25.0°C (only updates display)
        sensor.setTemperature(25.0f);

        // Set the temperature to 35.0°C (updates display and triggers alert)
        sensor.setTemperature(35.0f);
    }
}
