package singleton.singleton2.basic;

class Printer {
    private int numberOfPages;

    public Printer(int numberOfPages) {
        this.numberOfPages = numberOfPages;
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

    public void printCurrent(int numberOfPages) {
        Printer printer = new Printer(numberOfPages);
        printer.print("empleado: " + name + "\n" +
                "Posición: " + position + "\n" +
                " Función: " + role + "\n");
    }
}

class Main {
    public static void main(String[] args) {
        Employee andreas = new Employee("Andreas",
                "Jefe",
                "Gestiona la sucursal");
        Employee julia = new Employee("Julia",
                "Consultor",
                "Asesora a los clientes sobre las quejas");
        Employee tom = new Employee("Tom",
                "Venta",
                "Vende los productos");
        Employee stefanie = new Employee("Stefanie",
                "Desarrollador",
                " Mantenimiento informático en la sucursal.");
        Employee matthias = new Employee("Matthias",
                "Contable",
                "contabilidad financiera de la sucursal.");
        andreas.printCurrent(5);
        julia.printCurrent(5);
        tom.printCurrent(4);
        stefanie.printCurrent(3);
        matthias.printCurrent(7);
    }
}