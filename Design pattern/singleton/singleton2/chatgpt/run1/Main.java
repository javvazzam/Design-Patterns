package singleton.singleton2.chatgpt.run1;

class Printer {
    private static Printer instance;
    private int numberOfPages;

    private Printer() {
        this.numberOfPages = 0;
    }

    public static Printer getInstance() {
        if (instance == null) {
            instance = new Printer();
        }
        return instance;
    }

    public void print(String text) {
        System.out.println(text +
                "\n" + "número de páginas impresas hoy: " + ++numberOfPages +
                "\n" + "---------");
    }
}

class Employee {
    private String name;
    private String position;
    private String role;

    public Employee(String name, String position, String role) {
        this.name = name;
        this.position = position;
        this.role = role;
    }

    public void printCurrent() {
        Printer printer = Printer.getInstance();
        printer.print("Empleado: " + name + "\n" +
                "Posición: " + position + "\n" +
                "Función: " + role + "\n");
    }
}

public class Main {
    public static void main(String[] args) {
        Employee andreas = new Employee("Andreas", "Jefe", "Gestiona la sucursal");
        Employee julia = new Employee("Julia", "Consultor", "Asesora a los clientes sobre las quejas");
        Employee tom = new Employee("Tom", "Venta", "Vende los productos");
        Employee stefanie = new Employee("Stefanie", "Desarrollador", "Mantenimiento informático en la sucursal");
        Employee matthias = new Employee("Matthias", "Contable", "Contabilidad financiera de la sucursal");

        andreas.printCurrent();
        julia.printCurrent();
        tom.printCurrent();
        stefanie.printCurrent();
        matthias.printCurrent();
    }
}
