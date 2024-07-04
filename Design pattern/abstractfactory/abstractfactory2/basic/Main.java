package abstractfactory.abstractfactory2.basic;

class PineTree {
    String type = "Pine tree";

    String getType() {
        return type;
    }
}

class CherryTree {
    String type = "Cherry tree";

    String getType() {
        return type;
    }
}

class AppleTree {
    String type = "Apple tree";

    String getType() {
        return type;
    }
}

class OrangeTree {
    String type = "Orange tree";

    String getType() {
        return type;
    }
}

public class Main {
    public static void main(String[] args) {
        PineTree pineTree = new PineTree();
        CherryTree cherryTree = new CherryTree();
        AppleTree appleTree = new AppleTree();
        OrangeTree orangeTree = new OrangeTree();
        
        System.out.println("You planted a " + pineTree.getType());
        System.out.println("You planted a " + cherryTree.getType());
        System.out.println("You planted a " + appleTree.getType());
        System.out.println("You planted a " + orangeTree.getType());

    }
}

