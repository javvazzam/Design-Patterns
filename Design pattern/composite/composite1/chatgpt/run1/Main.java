package composite.composite1.chatgpt.run1;


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

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Object obj : contents) {
            if (obj instanceof Product) {
                totalPrice += ((Product) obj).getPrice();
            } else if (obj instanceof Box) {
                totalPrice += ((Box) obj).getTotalPrice();
            }
        }
        return totalPrice;
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
        // Create some products
        Product product1 = new Product("Laptop", 999.99);
        Product product2 = new Product("Phone", 499.99);
        Product product3 = new Product("Tablet", 299.99);

        // Create some boxes
        Box box1 = new Box("Electronics");
        Box box2 = new Box("Gadgets");

        // Add products to the boxes
        box1.addProduct(product1);
        box2.addProduct(product2);
        box2.addProduct(product3);

        // Create a larger box that contains other boxes
        Box bigBox = new Box("Big Box");
        bigBox.addBox(box1);
        bigBox.addBox(box2);

        // Display the contents of the big box
        System.out.println(bigBox.toString());

        // Display the total price of the big box
        System.out.println("Total price of " + bigBox.getLabel() + ": " + bigBox.getTotalPrice());
    }
}



