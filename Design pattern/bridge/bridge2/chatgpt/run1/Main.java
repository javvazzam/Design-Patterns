package bridge.bridge2.chatgpt.run1;

abstract class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Template methods
    abstract double getArea();
    abstract double getPerimeter();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

class Square extends Shape {
    private double side;

    public Square(double side, String color) {
        super(color);
        this.side = side;
    }

    @Override
    double getArea() {
        return side * side;
    }

    @Override
    double getPerimeter() {
        return 4 * side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5, "Red");
        System.out.println("Circle Area: " + circle.getArea());
        System.out.println("Circle Perimeter: " + circle.getPerimeter());
        System.out.println("Circle Color: " + circle.getColor());

        Square square = new Square(4, "Blue");
        System.out.println("Square Area: " + square.getArea());
        System.out.println("Square Perimeter: " + square.getPerimeter());
        System.out.println("Square Color: " + square.getColor());
    }
}

