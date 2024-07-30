package composite.composite1.chatgpt.run2;

// Box Class
import java.util.ArrayList;
import java.util.List;

// Component Interface
interface Component {
    double calculateTotalPrice();
    String getLabel(); // Optional, useful for displaying or debugging
}

// Product Class
class Product implements Component {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double calculateTotalPrice() {
        return price;
    }

    public String getLabel() {
        return name;
    }

    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }
}


class Box implements Component {
    private String label;
    private List<Component> contents;

    public Box(String label) {
        this.label = label;
        this.contents = new ArrayList<>();
    }

    public void addProduct(Product product) {
        contents.add(product);
    }

    public void addBox(Box box) {
        contents.add(box);
    }

    public List<Component> getContents() {
        return contents;
    }

    @Override
    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Component component : contents) {
            totalPrice += component.calculateTotalPrice();
        }
        return totalPrice;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Box{label='").append(label).append("', contents=\n");
        for (Component component : contents) {
            sb.append("  ").append(component.toString()).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        // Crear algunos productos
        Product product1 = new Product("Laptop", 999.99);
        Product product2 = new Product("Phone", 499.99);
        Product product3 = new Product("Tablet", 299.99);

        // Crear algunas cajas
        Box box1 = new Box("Electronics");
        Box box2 = new Box("Gadgets");

        // Añadir productos a las cajas
        box1.addProduct(product1);
        box2.addProduct(product2);
        box2.addProduct(product3);

        // Crear una caja más grande que contenga otras cajas
        Box bigBox = new Box("Big Box");
        bigBox.addBox(box1);
        bigBox.addBox(box2);

        // Mostrar el contenido de la caja grande
        System.out.println(bigBox.toString());

        // Mostrar el precio total de la caja grande
        System.out.println("Total Price of " + bigBox.getLabel() + ": $" + bigBox.calculateTotalPrice());
    }
}
