package visitor.visitor2.basic;

import java.util.ArrayList;
import java.util.List;

interface Shape {
    void move(int x, int y);

    void draw();
}

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
        System.out
                .println("Drawing a rectangle at (" + x + ", " + y + ") with width " + width + " and height " + height);
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

class CompoundShape implements Shape {
    private List<Shape> children = new ArrayList<>();
    private int id; // Assume each compound shape has an ID for identification

    public CompoundShape(int id) {
        this.id = id;
    }

    @Override
    public void move(int x, int y) {
        // Move all children shapes
        for (Shape shape : children) {
            shape.move(x, y);
        }
        System.out.println("CompoundShape moved to (" + x + ", " + y + ")");
    }

    @Override
    public void draw() {
        // Draw all children shapes
        for (Shape shape : children) {
            shape.draw();
        }
        System.out.println("Drawing CompoundShape with ID " + id);
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
    }
}

// I want to calculate the area of each shape without modifying the implementation of them, in case the structure of the shapes change.
