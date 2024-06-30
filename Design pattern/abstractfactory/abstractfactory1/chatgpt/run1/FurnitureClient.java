package abstractfactory.abstractfactory1.chatgpt.run1;

// Furniture interfaces
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

// Victorian furniture classes
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

// Modern furniture classes
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

// Abstract factory interface
interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
    CoffeeTable createCoffeeTable();
}

// Victorian furniture factory
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

// Modern furniture factory
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

// Client code
public class FurnitureClient {
    private Chair chair;
    private Sofa sofa;
    private CoffeeTable coffeeTable;

    public FurnitureClient(FurnitureFactory factory) {
        this.chair = factory.createChair();
        this.sofa = factory.createSofa();
        this.coffeeTable = factory.createCoffeeTable();
    }

    public void describeFurniture() {
        System.out.println(chair.describe());
        System.out.println(sofa.describe());
        System.out.println(coffeeTable.describe());
    }

    public void sitOnFurniture() {
        System.out.println(chair.sitOn());
        System.out.println(sofa.sitOn());
        System.out.println(coffeeTable.sitOn());
    }

    public static void main(String[] args) {
        // Creating Victorian furniture
        System.out.println("Victorian Furniture:");
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        FurnitureClient victorianClient = new FurnitureClient(victorianFactory);
        victorianClient.describeFurniture();
        victorianClient.sitOnFurniture();

        System.out.println();

        // Creating Modern furniture
        System.out.println("Modern Furniture:");
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        FurnitureClient modernClient = new FurnitureClient(modernFactory);
        modernClient.describeFurniture();
        modernClient.sitOnFurniture();
    }
}
