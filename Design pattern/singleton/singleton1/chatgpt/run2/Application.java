package singleton.singleton1.chatgpt.run2;

class Database {
    // Step 1: Create a private static instance of the class
    private static Database instance;

    // Step 2: Make the constructor private to prevent instantiation from other classes
    private Database() {
        // Initialize a new database connection (simulation)
        System.out.println("Database connection established.");
    }

    // Step 3: Provide a public static method to get the instance of the class
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    // Method to apply a query to the database (simulation)
    public void query(String sql) {
        // Apply the query to the database (simulation)
        System.out.println("Executing query: " + sql);
    }
}

public class Application {
    public static void main(String[] args) {
        // Step 4: Get the Singleton instance of the Database class
        Database db = Database.getInstance();

        // Step 5: Add data to the database
        db.query("INSERT INTO users (name, age) VALUES ('Alice', 30)");
        db.query("INSERT INTO users (name, age) VALUES ('Bob', 25)");
        db.query("INSERT INTO users (name, age) VALUES ('Charlie', 35)");

        // Additional data can be added using the same db instance
        db.query("UPDATE users SET age = 31 WHERE name = 'Alice'");
    }
}

