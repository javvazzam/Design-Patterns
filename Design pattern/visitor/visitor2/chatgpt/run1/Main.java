package visitor.visitor2.chatgpt.run1;

import java.util.ArrayList;
import java.util.List;

// Shape interface with the accept method for visitor
interface Shape {
    void move(int x, int y);
    void draw();
    void accept(ShapeVisitor visitor);  // New method for visitor acceptance
    int getId();
}

// Dot class implementing the Shape interface
class Dot implements Shape {
    private int x, y;
    private int id;

    public Dot(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Dot moved to (" + x + ", " + y + ")");
    }

    @Override
    public void draw() {
        System.out.println("Drawing a dot at (" + x + ", " + y + ")");
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

// Circle class implementing the Shape interface
class Circle implements Shape {
    private int x, y, radius;
    private int id;

    public Circle(int x, int y, int radius, int id) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.id = id;
    }

    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Circle moved to (" + x + ", " + y + ")");
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle at (" + x + ", " + y + ") with radius " + radius);
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }
}

// Rectangle class implementing the Shape interface
class Rectangle implements Shape {
    private int x, y, width, height;
    private int id;

    public Rectangle(int x, int y, int width, int height, int id) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = id;
    }

    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Rectangle moved to (" + x + ", " + y + ")");
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle at (" + x + ", " + y + ") with width " + width + " and height " + height);
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

// CompoundShape class implementing the Shape interface
class CompoundShape implements Shape {
    private List<Shape> children = new ArrayList<>();
    private int id;

    public CompoundShape(int id) {
        this.id = id;
    }

    @Override
    public void move(int x, int y) {
        for (Shape shape : children) {
            shape.move(x, y);
        }
        System.out.println("CompoundShape moved to (" + x + ", " + y + ")");
    }

    @Override
    public void draw() {
        for (Shape shape : children) {
            shape.draw();
        }
        System.out.println("Drawing CompoundShape with ID " + id);
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }

    public void add(Shape shape) {
        children.add(shape);
    }

    public List<Shape> getChildren() {
        return children;
    }

    public int getId() {
        return id;
    }
}

// ShapeVisitor interface
interface ShapeVisitor {
    void visit(Dot dot);
    void visit(Circle circle);
    void visit(Rectangle rectangle);
    void visit(CompoundShape compoundShape);
}

// AreaCalculator class implementing the ShapeVisitor interface
class AreaCalculator implements ShapeVisitor {
    private double area;

    @Override
    public void visit(Dot dot) {
        // Area of a dot is considered to be 0
        area = 0;
    }

    @Override
    public void visit(Circle circle) {
        area = Math.PI * Math.pow(circle.getRadius(), 2);
    }

    @Override
    public void visit(Rectangle rectangle) {
        area = rectangle.getWidth() * rectangle.getHeight();
    }

    @Override
    public void visit(CompoundShape compoundShape) {
        area = 0;
        for (Shape shape : compoundShape.getChildren()) {
            shape.accept(this);
            area += this.area;  // Accumulate the area of each child shape
        }
    }

    public double getArea() {
        return area;
    }
}

// Main class with an executable example
public class Main {
    public static void main(String[] args) {
        // Create a list of shapes
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Dot(10, 20, 1));
        shapes.add(new Circle(30, 40, 50, 2));
        shapes.add(new Rectangle(50, 60, 70, 80, 3));

        // Create a compound shape and add shapes to it
        CompoundShape compound = new CompoundShape(4);
        compound.add(new Dot(15, 25, 5));
        compound.add(new Circle(35, 45, 55, 6));
        shapes.add(compound);

        // Calculate and print the area of each shape
        for (Shape shape : shapes) {
            AreaCalculator areaCalculator = new AreaCalculator();
            shape.accept(areaCalculator);
            System.out.println("Area of shape with ID " + shape.getId() + " is " + areaCalculator.getArea());
        }
    }
}

