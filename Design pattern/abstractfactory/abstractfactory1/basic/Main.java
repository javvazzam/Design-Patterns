package abstractfactory.abstractfactory1.basic;

class VictorianChair {
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

class VictorianSofa {
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

class VictorianCoffeeTable {
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

class ModernChair {
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

class ModernSofa {
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

class ModernCoffeeTable {
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

public class Main {
    public static void main(String[] args) {
        VictorianChair victorianChair = new VictorianChair();
        VictorianSofa victorianSofa = new VictorianSofa();
        VictorianCoffeeTable victorianCoffeeTable = new VictorianCoffeeTable();

        ModernChair modernChair = new ModernChair();
        ModernSofa modernSofa = new ModernSofa();
        ModernCoffeeTable modernCoffeeTable = new ModernCoffeeTable();

        System.out.println(victorianChair.describe());
        System.out.println(victorianSofa.describe());
        System.out.println(victorianCoffeeTable.describe());

        System.out.println(modernChair.describe());
        System.out.println(modernSofa.describe());
        System.out.println(modernCoffeeTable.describe());
    }
}
