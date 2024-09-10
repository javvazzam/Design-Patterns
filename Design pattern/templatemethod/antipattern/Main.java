package templatemethod.antipattern;

class TextFileProcessor {
    public void openFile() {
        System.out.println("Opening text file...");
    }

    public void readData() {
        System.out.println("Reading data from text file...");
    }

    public void processData() {
        System.out.println("Processing text file data...");
    }

    public void closeFile() {
        System.out.println("Text file closed.");
    }
}

class XMLFileProcessor {
    public void openFile() {
        System.out.println("Opening XML file...");
    }

    public void readData() {
        System.out.println("Reading data from XML file...");
    }

    public void processData() {
        System.out.println("Processing XML file data...");
    }

    public void closeFile() {
        System.out.println("XML file closed.");
    }

    public void validateData() {
        System.out.println("Validating XML file data...");
    }
}

class BinaryFileProcessor {
    public void openFile() {
        System.out.println("Opening binary file...");
    }

    public void readData() {
        System.out.println("Reading data from binary file...");
    }

    public void processData() {
        System.out.println("Processing binary file data...");
    }

    public void closeFile() {
        System.out.println("Binary file closed.");
    }
}
