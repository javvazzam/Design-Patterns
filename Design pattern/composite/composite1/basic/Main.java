package composite.composite1.basic;

import java.util.ArrayList;
import java.util.List;

class Product {
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

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }
}

class Box {
    private String label;
    private List<Object> contents;

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

    public List<Object> getContents() {
        return contents;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Box{label='").append(label).append("', contents=\n");
        for (Object obj : contents) {
            sb.append("  ").append(obj.toString()).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 999.99);
        Product product2 = new Product("Phone", 499.99);
        Product product3 = new Product("Tablet", 299.99);

        Box box1 = new Box("Electronics");
        Box box2 = new Box("Gadgets");

        box1.addProduct(product1);
        box2.addProduct(product2);
        box2.addProduct(product3);

        Box bigBox = new Box("Big Box");
        bigBox.addBox(box1);
        bigBox.addBox(box2);

        System.out.println(bigBox.toString());
    }
}

