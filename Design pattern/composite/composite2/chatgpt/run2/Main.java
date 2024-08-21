package composite.composite2.chatgpt.run2;

import java.util.ArrayList;
import java.util.List;

// Common interface for both File and Directory
interface FileSystemComponent {
    int getSize();
    String getName();
}

// Leaf class representing a File
class File implements FileSystemComponent {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "File{name='" + name + "', size=" + size + "}";
    }
}

// Composite class representing a Directory
class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        children.add(component);
    }

    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : children) {
            totalSize += component.getSize();
        }
        return totalSize;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Directory{name='").append(name).append("', children=\n");
        for (FileSystemComponent component : children) {
            sb.append("  ").append(component.toString()).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}

// Main class to demonstrate the functionality
public class Main {
    public static void main(String[] args) {
        // Creating individual files
        File file1 = new File("file1.txt", 100);
        File file2 = new File("file2.txt", 200);
        File file3 = new File("file3.txt", 300);

        // Creating directories and adding files to them
        Directory dir1 = new Directory("dir1");
        dir1.add(file1);
        dir1.add(file2);

        Directory dir2 = new Directory("dir2");
        dir2.add(file3);
        dir2.add(dir1); // Adding dir1 as a subdirectory of dir2

        // Creating the root directory and adding other directories and files
        Directory root = new Directory("root");
        root.add(dir1);
        root.add(dir2);
        root.add(file1);  // Adding a file directly to the root directory

        // Printing the structure of the root directory
        System.out.println("Compose Directory Structure: ");
        System.out.println(root.toString());

        // Calculating and printing the total size of the root directory
        System.out.println("Total Size of root: " + root.getSize() + " bytes");
    }
}


