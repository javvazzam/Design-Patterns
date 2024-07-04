package singleton.singleton1.chatgpt.run1;

// Database.java
class Database {
    private static Database instance;

    private Database() {
        // Initialize a new database connection (simulated)
        System.out.println("Database connection initialized.");
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void query(String sql) {
        // Simulate executing a query
        System.out.println("Executing query: " + sql);
    }
}

// Application.java
class Application {
    public static void main(String[] args) {
        // Get the singleton instance of Database
        Database db = Database.getInstance();

        // Perform some queries
        db.query("SELECT * FROM users");
        db.query("INSERT INTO users (name, age) VALUES ('Alice', 30)");
        db.query("UPDATE users SET age = 31 WHERE name = 'Alice'");

        // Get another reference to the singleton instance
        Database anotherDbInstance = Database.getInstance();

        // Verify both references point to the same instance
        if (db == anotherDbInstance) {
            System.out.println("Both references point to the same instance.");
        } else {
            System.out.println("References point to different instances.");
        }

        // Perform more queries using the new reference
        anotherDbInstance.query("DELETE FROM users WHERE name = 'Alice'");
    }
}

