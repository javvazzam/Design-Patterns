package proxy.proxy2.chatgpt.run2;

// Enum to represent user roles
enum UserRole {
    ADMIN,
    USER,
    GUEST
}

// Interface representing the file service library
interface FileServiceLib {
    void readFile(String fileName);
    void writeFile(String fileName, String content);
}

// Concrete implementation of the FileServiceLib interface
class FileService implements FileServiceLib {

    @Override
    public void readFile(String fileName) {
        System.out.println("Reading file: " + fileName);
        // Code to read a file from the file system would go here
    }

    @Override
    public void writeFile(String fileName, String content) {
        System.out.println("Writing to file: " + fileName + " Content: " + content);
        // Code to write to a file in the file system would go here
    }
}

// Proxy class to control access based on role
class FileServiceProxy implements FileServiceLib {
    private final FileService fileService;
    private final UserRole userRole;

    public FileServiceProxy(FileService fileService, UserRole userRole) {
        this.fileService = fileService;
        this.userRole = userRole;
    }

    @Override
    public void readFile(String fileName) {
        if (userRole == UserRole.ADMIN || userRole == UserRole.USER) {
            fileService.readFile(fileName);
        } else {
            System.out.println("Access Denied: You do not have permission to read files.");
        }
    }

    @Override
    public void writeFile(String fileName, String content) {
        if (userRole == UserRole.ADMIN) {
            fileService.writeFile(fileName, content);
        } else {
            System.out.println("Access Denied: You do not have permission to write to files.");
        }
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        FileService fileService = new FileService();

        // Create a proxy for an admin user
        FileServiceLib adminService = new FileServiceProxy(fileService, UserRole.ADMIN);
        System.out.println("Admin User:");
        adminService.readFile("admin.txt");
        adminService.writeFile("admin.txt", "Admin content");
        System.out.println();

        // Create a proxy for a regular user
        FileServiceLib userService = new FileServiceProxy(fileService, UserRole.USER);
        System.out.println("Regular User:");
        userService.readFile("user.txt");
        userService.writeFile("user.txt", "User content");
        System.out.println();

        // Create a proxy for a guest user
        FileServiceLib guestService = new FileServiceProxy(fileService, UserRole.GUEST);
        System.out.println("Guest User:");
        guestService.readFile("guest.txt");
        guestService.writeFile("guest.txt", "Guest content");
    }
}

