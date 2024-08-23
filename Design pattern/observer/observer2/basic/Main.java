package observer.observer2.basic;

class TemperatureSensor {
    private float temperature;

    // Métodos para actualizar y obtener la temperatura
    public void setTemperature(float temperature) {
        this.temperature = temperature;
        updateDisplay();
        checkAlert();
    }

    public float getTemperature() {
        return temperature;
    }

    // Métodos específicos de notificación
    private void updateDisplay() {
        System.out.println("La temperatura actual es: " + temperature + "°C");
    }

    private void checkAlert() {
        if (temperature > 30.0f) {
            System.out.println("¡Alerta! La temperatura ha superado el umbral: " + temperature + "°C");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TemperatureSensor sensor = new TemperatureSensor();
        
        sensor.setTemperature(25.0f);  
        sensor.setTemperature(35.0f);  // Activa la alerta
    }
}

// I want to make this code scalable and separate the functionality of the checks that activates the messages through the screen
