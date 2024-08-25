package visitor.visitor2.chatgpt.run2;

import java.util.ArrayList;
import java.util.List;

// Shape Interface
interface Shape {
    void move(int x, int y);
    void draw();
    double accept(ShapeVisitor visitor);
}

// Dot Class
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
    public double accept(ShapeVisitor visitor) {
        return visitor.visit(this);
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

// Circle Class
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
    public double accept(ShapeVisitor visitor) {
        return visitor.visit(this);
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

// Rectangle Class
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
    public double accept(ShapeVisitor visitor) {
        return visitor.visit(this);
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

// CompoundShape Class
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
    public double accept(ShapeVisitor visitor) {
        return visitor.visit(this);
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

// ShapeVisitor Interface
interface ShapeVisitor {
    double visit(Dot dot);
    double visit(Circle circle);
    double visit(Rectangle rectangle);
    double visit(CompoundShape compoundShape);
}

// AreaCalculator Class
class AreaCalculator implements ShapeVisitor {

    @Override
    public double visit(Dot dot) {
        // A dot doesn't really have an area, so return 0.
        return 0;
    }

    @Override
    public double visit(Circle circle) {
        return Math.PI * circle.getRadius() * circle.getRadius();
    }

    @Override
    public double visit(Rectangle rectangle) {
        return rectangle.getWidth() * rectangle.getHeight();
    }

    @Override
    public double visit(CompoundShape compoundShape) {
        double totalArea = 0;
        for (Shape shape : compoundShape.getChildren()) {
            totalArea += shape.accept(this);
        }
        return totalArea;
    }
}

// Main Class to Execute the Program
public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Dot(10, 20, 1));
        shapes.add(new Circle(30, 40, 50, 2));
        shapes.add(new Rectangle(50, 60, 70, 80, 3));

        CompoundShape compound = new CompoundShape(4);
        compound.add(new Dot(15, 25, 5));
        compound.add(new Circle(35, 45, 55, 6));
        shapes.add(compound);

        AreaCalculator areaCalculator = new AreaCalculator();

        for (Shape shape : shapes) {
            double area = shape.accept(areaCalculator);
            System.out.println("Area: " + area);
        }
    }
}

