package bridge.bridge2.chatgpt.run2;

abstract class Shape {
    abstract double getArea();
    abstract double getPerimeter();
    abstract String getDescription(); // New abstract method for description
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
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

    @Override
    String getDescription() {
        return "Circle with radius " + radius;
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

    public Square(double side) {
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

    @Override
    String getDescription() {
        return "Square with side " + side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}

abstract class ShapeDecorator extends Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    double getArea() {
        return decoratedShape.getArea();
    }

    @Override
    double getPerimeter() {
        return decoratedShape.getPerimeter();
    }

    @Override
    String getDescription() {
        return decoratedShape.getDescription();
    }
}

class ColorDecorator extends ShapeDecorator {
    private String color;

    public ColorDecorator(Shape decoratedShape, String color) {
        super(decoratedShape);
        this.color = color;
    }

    @Override
    String getDescription() {
        return decoratedShape.getDescription() + " and color " + color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape coloredCircle = new ColorDecorator(circle, "Red");
        System.out.println("Circle Area: " + coloredCircle.getArea());
        System.out.println("Circle Perimeter: " + coloredCircle.getPerimeter());
        System.out.println("Circle Description: " + coloredCircle.getDescription());

        Shape square = new Square(4);
        Shape coloredSquare = new ColorDecorator(square, "Blue");
        System.out.println("Square Area: " + coloredSquare.getArea());
        System.out.println("Square Perimeter: " + coloredSquare.getPerimeter());
        System.out.println("Square Description: " + coloredSquare.getDescription());
    }
}

