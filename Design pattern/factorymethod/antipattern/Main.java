package factorymethod.antipattern;

interface Producto {
    void usar();
}

class ProductoA implements Producto {
    @Override
    public void usar() {
        System.out.println("Usando ProductoA");
    }
}

class ProductoB implements Producto {
    @Override
    public void usar() {
        System.out.println("Usando ProductoB");
    }
}

class ProductoC implements Producto {
    @Override
    public void usar() {
        System.out.println("Usando ProductoC");
    }
}

public class Main {
    public static void main(String[] args) {

        Producto productoA = new ProductoA();
        Producto productoB = new ProductoB();
        Producto productoC = new ProductoC();

        productoA.usar();
        productoB.usar();
        productoC.usar();
    }
}