package singleton.antipattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class SimulatedResource {
    private final int id;

    public SimulatedResource(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void use() {
        System.out.println("Usando recurso " + id + " por el hilo " + Thread.currentThread().getName());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Recurso " + id + " liberado por el hilo " + Thread.currentThread().getName());
    }
}

class ResourcePool {

    private List<SimulatedResource> availableResources = new ArrayList<>();
    private final int MAX_RESOURCES = 5;

    public ResourcePool() {
        for (int i = 0; i < MAX_RESOURCES; i++) {
            availableResources.add(new SimulatedResource(i));
        }
    }

    public synchronized SimulatedResource acquireResource() {
        if (availableResources.isEmpty()) {
            System.out.println("No hay recursos disponibles, creando uno nuevo.");
            return new SimulatedResource(-1);
        } else {
            return availableResources.remove(availableResources.size() - 1);
        }
    }

    public synchronized void releaseResource(SimulatedResource resource) {
        if (resource.getId() != -1) { 
            availableResources.add(resource);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ResourcePool pool = new ResourcePool();

        // Ejemplo de uso en múltiples hilos
        Runnable task = () -> {
            SimulatedResource resource = pool.acquireResource();
            try {
                resource.use();
            } finally {
                pool.releaseResource(resource);
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(task).start();
        }
    }
}


