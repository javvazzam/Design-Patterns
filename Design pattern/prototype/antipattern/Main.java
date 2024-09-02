package prototype.antipattern;

class DatabaseConnection {
    private String connectionString;
    private boolean isConnected;

    public DatabaseConnection(String connectionString) {
        this.connectionString = connectionString;
        this.isConnected = false;
        connect();
    }

    private void connect() {
        if (!isConnected) {
            System.out.println("Conectando a la base de datos con: " + connectionString);
            isConnected = true;
        }
    }

    public void close() {
        if (isConnected) {
            System.out.println("Cerrando la conexión a la base de datos.");
            isConnected = false;
        }
    }
    
    public void executeQuery(String query) {
        if (isConnected) {
            System.out.println("Ejecutando consulta: " + query);
        } else {
            System.out.println("No se puede ejecutar la consulta, no hay conexión.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        DatabaseConnection connection = new DatabaseConnection("jdbc:mysql://localhost:3306/mydb");
        
        connection.executeQuery("SELECT * FROM users");
        connection.executeQuery("SELECT * FROM orders");

        connection.close();
    }
}
