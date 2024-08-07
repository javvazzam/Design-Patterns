package composite.composite2.basic;

import java.util.ArrayList;
import java.util.List;

class File {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "File{name='" + name + "', size=" + size + "}";
    }
}

class Directory {
    private String name;
    private List<Object> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(Object object) {
        children.add(object);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Directory{name='").append(name).append("', children=\n");
        for (Object obj : children) {
            sb.append("  ").append(obj.toString()).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
         File file1 = new File("file1.txt", 100);
         File file2 = new File("file2.txt", 200);
         File file3 = new File("file3.txt", 300);
 
         Directory dir1 = new Directory("dir1");
         Directory dir2 = new Directory("dir2");
 
         dir1.add(file1);
         dir1.add(file2);
 
         dir2.add(file3);
         dir2.add(dir1);
 
         Directory root = new Directory("root");
         root.add(dir1);
         root.add(dir2);
         root.add(file1);  
 
         System.out.println("Compose Directory: " + root.toString());
    }
}

//Get the size and the structure of the final directory