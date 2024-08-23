package observer.observer2.chatgpt.run1;

import java.util.ArrayList;
import java.util.List;

interface TemperatureObserver {
    void onTemperatureChange(float temperature);
}

class DisplayObserver implements TemperatureObserver {
    @Override
    public void onTemperatureChange(float temperature) {
        System.out.println("La temperatura actual es: " + temperature + "°C");
    }
}

class AlertObserver implements TemperatureObserver {
    private static final float ALERT_THRESHOLD = 30.0f;

    @Override
    public void onTemperatureChange(float temperature) {
        if (temperature > ALERT_THRESHOLD) {
            System.out.println("¡Alerta! La temperatura ha superado el umbral: " + temperature + "°C");
        }
    }
}

class TemperatureSensor {
    private float temperature;
    private List<TemperatureObserver> observers = new ArrayList<>();

    // Method to add observers
    public void addObserver(TemperatureObserver observer) {
        observers.add(observer);
    }

    // Method to remove observers
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
            observer.onTemperatureChange(temperature);
        }
    }
}

class Main {
    public static void main(String[] args) {
        // Create an instance of the temperature sensor
        TemperatureSensor sensor = new TemperatureSensor();
        
        // Add observers
        sensor.addObserver(new DisplayObserver());
        sensor.addObserver(new AlertObserver());
        
        // Set temperature to test observer notifications
        sensor.setTemperature(25.0f);  
        sensor.setTemperature(35.0f);  // This should trigger the alert
    }
}

