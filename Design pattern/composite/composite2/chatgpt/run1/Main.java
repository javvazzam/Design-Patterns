package composite.composite2.chatgpt.run1;

import java.util.ArrayList;
import java.util.List;

// Common interface for File and Directory
interface FileSystemComponent {
    int getSize();
    String getName();
    String toString();
}

// Leaf component: File
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

// Composite component: Directory
class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        children.add(component);
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

// Client: Main class
public class Main {
    public static void main(String[] args) {
        // Creating files
        File file1 = new File("file1.txt", 100);
        File file2 = new File("file2.txt", 200);
        File file3 = new File("file3.txt", 300);

        // Creating directories
        Directory dir1 = new Directory("dir1");
        Directory dir2 = new Directory("dir2");

        // Adding files to directories
        dir1.add(file1);
        dir1.add(file2);

        // Adding files and subdirectories to directories
        dir2.add(file3);
        dir2.add(dir1);

        // Creating root directory and adding files and directories
        Directory root = new Directory("root");
        root.add(dir1);
        root.add(dir2);
        root.add(file1);  // Adding the same file to root for demonstration

        // Printing the structure and total size
        System.out.println("Compose Directory: " + root.toString());
        System.out.println("Total size of root directory: " + root.getSize() + " KB");
    }
}

