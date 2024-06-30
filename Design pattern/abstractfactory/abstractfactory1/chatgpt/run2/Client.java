package abstractfactory.abstractfactory1.chatgpt.run2;

// Abstract Furniture interfaces
interface Chair {
    String describe();
    String sitOn();
}

interface Sofa {
    String describe();
    String sitOn();
}

interface CoffeeTable {
    String describe();
    String sitOn();
}

// Victorian Chair class
class VictorianChair implements Chair {
    private String material;
    private String color;
    private String style;

    public VictorianChair() {
        this.material = "wood";
        this.color = "brown";
        this.style = "victorian";
    }

    public String describe() {
        return "This is a " + style + " chair made of " + material + " and is " + color + " in color.";
    }

    public String sitOn() {
        return "Sitting on a " + style + " chair.";
    }
}

// Victorian Sofa class
class VictorianSofa implements Sofa {
    private String material;
    private String color;
    private String style;

    public VictorianSofa() {
        this.material = "wood";
        this.color = "brown";
        this.style = "victorian";
    }

    public String describe() {
        return "This is a " + style + " sofa made of " + material + " and is " + color + " in color.";
    }

    public String sitOn() {
        return "Sitting on a " + style + " sofa.";
    }
}

// Victorian Coffee Table class
class VictorianCoffeeTable implements CoffeeTable {
    private String material;
    private String color;
    private String style;

    public VictorianCoffeeTable() {
        this.material = "wood";
        this.color = "brown";
        this.style = "victorian";
    }

    public String describe() {
        return "This is a " + style + " coffee table made of " + material + " and is " + color + " in color.";
    }

    public String sitOn() {
        return "Sitting on a " + style + " coffee table.";
    }
}

// Modern Chair class
class ModernChair implements Chair {
    private String material;
    private String color;
    private String style;

    public ModernChair() {
        this.material = "metal";
        this.color = "gray";
        this.style = "modern";
    }

    public String describe() {
        return "This is a " + style + " chair made of " + material + " and is " + color + " in color.";
    }

    public String sitOn() {
        return "Sitting on a " + style + " chair.";
    }
}

// Modern Sofa class
class ModernSofa implements Sofa {
    private String material;
    private String color;
    private String style;

    public ModernSofa() {
        this.material = "metal";
        this.color = "gray";
        this.style = "modern";
    }

    public String describe() {
        return "This is a " + style + " sofa made of " + material + " and is " + color + " in color.";
    }

    public String sitOn() {
        return "Sitting on a " + style + " sofa.";
    }
}

// Modern Coffee Table class
class ModernCoffeeTable implements CoffeeTable {
    private String material;
    private String color;
    private String style;

    public ModernCoffeeTable() {
        this.material = "metal";
        this.color = "gray";
        this.style = "modern";
    }

    public String describe() {
        return "This is a " + style + " coffee table made of " + material + " and is " + color + " in color.";
    }

    public String sitOn() {
        return "Sitting on a " + style + " coffee table.";
    }
}

// Abstract Factory interface
interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
    CoffeeTable createCoffeeTable();
}

// Concrete factory for Victorian furniture
class VictorianFurnitureFactory implements FurnitureFactory {
    public Chair createChair() {
        return new VictorianChair();
    }

    public Sofa createSofa() {
        return new VictorianSofa();
    }

    public CoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }
}

// Concrete factory for Modern furniture
class ModernFurnitureFactory implements FurnitureFactory {
    public Chair createChair() {
        return new ModernChair();
    }

    public Sofa createSofa() {
        return new ModernSofa();
    }

    public CoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }
}

// Client code to create and use furniture
public class Client {
    private FurnitureFactory factory;

    public Client(FurnitureFactory factory) {
        this.factory = factory;
    }

    public void createFurniture() {
        Chair chair = factory.createChair();
        Sofa sofa = factory.createSofa();
        CoffeeTable coffeeTable = factory.createCoffeeTable();

        // Use the furniture
        System.out.println(chair.describe());
        System.out.println(chair.sitOn());
        System.out.println();

        System.out.println(sofa.describe());
        System.out.println(sofa.sitOn());
        System.out.println();

        System.out.println(coffeeTable.describe());
        System.out.println(coffeeTable.sitOn());
    }

    public static void main(String[] args) {
        // Create Victorian furniture
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        Client victorianClient = new Client(victorianFactory);
        System.out.println("Creating Victorian Furniture:");
        victorianClient.createFurniture();

        System.out.println();

        // Create Modern furniture
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        Client modernClient = new Client(modernFactory);
        System.out.println("Creating Modern Furniture:");
        modernClient.createFurniture();
    }
}

