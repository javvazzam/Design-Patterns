package proxy.proxy2.chatgpt.run1;

// Interface defining the file operations
interface FileServiceLib {
    void readFile(String fileName);
    void writeFile(String fileName, String content);
}

// The real subject that implements the file operations
class FileService implements FileServiceLib {

    @Override
    public void readFile(String fileName) {
        System.out.println("Reading file: " + fileName);
        // Simulate reading a file from the file system
    }

    @Override
    public void writeFile(String fileName, String content) {
        System.out.println("Writing to file: " + fileName + " Content: " + content);
        // Simulate writing to a file in the file system
    }
}

// Class representing a user with a name and a role
class User {
    private String name;
    private String role;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

// The proxy class that controls access based on the user's role
class FileServiceProxy implements FileServiceLib {
    private FileServiceLib fileService;
    private User user;

    public FileServiceProxy(User user) {
        this.fileService = new FileService(); // Using the real FileService
        this.user = user;
    }

    private boolean hasReadAccess() {
        return user.getRole().equals("admin") || user.getRole().equals("reader");
    }

    private boolean hasWriteAccess() {
        return user.getRole().equals("admin") || user.getRole().equals("writer");
    }

    @Override
    public void readFile(String fileName) {
        if (hasReadAccess()) {
            fileService.readFile(fileName);
        } else {
            System.out.println("Access denied: User does not have read permissions.");
        }
    }

    @Override
    public void writeFile(String fileName, String content) {
        if (hasWriteAccess()) {
            fileService.writeFile(fileName, content);
        } else {
            System.out.println("Access denied: User does not have write permissions.");
        }
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        User admin = new User("Alice", "admin");
        User reader = new User("Bob", "reader");
        User writer = new User("Charlie", "writer");
        User guest = new User("Dave", "guest");

        FileServiceLib fileServiceForAdmin = new FileServiceProxy(admin);
        fileServiceForAdmin.readFile("admin.txt");
        fileServiceForAdmin.writeFile("admin.txt", "Admin data");

        FileServiceLib fileServiceForReader = new FileServiceProxy(reader);
        fileServiceForReader.readFile("reader.txt");
        fileServiceForReader.writeFile("reader.txt", "Reader data");

        FileServiceLib fileServiceForWriter = new FileServiceProxy(writer);
        fileServiceForWriter.readFile("writer.txt");
        fileServiceForWriter.writeFile("writer.txt", "Writer data");

        FileServiceLib fileServiceForGuest = new FileServiceProxy(guest);
        fileServiceForGuest.readFile("guest.txt");
        fileServiceForGuest.writeFile("guest.txt", "Guest data");
    }
}

