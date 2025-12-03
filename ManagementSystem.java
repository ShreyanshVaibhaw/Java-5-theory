/**
 * ManagementSystem.java
 * Menu-driven application to add/display employees (uses an array to store Employee objects).
 * Demonstrates inheritance, polymorphism, method overriding, and method overloading.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManagementSystem {
    private Employee[] employees;
    private int count;
    private int nextId;
    private Scanner scanner;

    public ManagementSystem(int capacity) {
        employees = new Employee[capacity];
        count = 0;
        nextId = 101; // starting employee ID as example
        scanner = new Scanner(System.in);
    }

    // Overloaded addEmployee methods (demonstrates method overloading)
    public void addEmployee(Manager m) {
        if (count < employees.length) {
            employees[count++] = m;
            System.out.println("Manager added successfully.");
        } else {
            System.out.println("Employee storage full.");
        }
    }

    public void addEmployee(Developer d) {
        if (count < employees.length) {
            employees[count++] = d;
            System.out.println("Developer added successfully.");
        } else {
            System.out.println("Employee storage full.");
        }
    }

    // search by id
    public Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == id) return employees[i];
        }
        return null;
    }

    // overloaded search by name (returns first match)
    public Employee searchEmployee(String name) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getName().equalsIgnoreCase(name)) return employees[i];
        }
        return null;
    }

    public void displayAllEmployees() {
        if (count == 0) {
            System.out.println("No employees to display.");
            return;
        }
        System.out.println("All employees:");
        for (int i = 0; i < count; i++) {
            employees[i].displayDetails();
        }
    }

    private void createManager() {
        try {
            System.out.print("Enter Manager name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Enter salary: ");
            double salary = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Enter department: ");
            String dept = scanner.nextLine().trim();

            Manager m = new Manager(nextId++, name, salary, dept);
            addEmployee(m);
            System.out.println("Manager created with ID: " + m.getEmployeeId());
        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input. Returning to main menu.");
        }
    }

    private void createDeveloper() {
        try {
            System.out.print("Enter Developer name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Enter salary: ");
            double salary = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Enter primary programming language: ");
            String lang = scanner.nextLine().trim();

            Developer d = new Developer(nextId++, name, salary, lang);
            addEmployee(d);
            System.out.println("Developer created with ID: " + d.getEmployeeId());
        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input. Returning to main menu.");
        }
    }

    private void displayEmployeeDetails() {
        try {
            System.out.print("Search by (1) ID or (2) Name? Enter 1 or 2: ");
            int choice = Integer.parseInt(scanner.nextLine().trim());
            if (choice == 1) {
                System.out.print("Enter Employee ID: ");
                int id = Integer.parseInt(scanner.nextLine().trim());
                Employee e = searchEmployee(id);
                if (e != null) e.displayDetails();
                else System.out.println("Employee with ID " + id + " not found.");
            } else if (choice == 2) {
                System.out.print("Enter Employee Name: ");
                String name = scanner.nextLine().trim();
                Employee e = searchEmployee(name);
                if (e != null) e.displayDetails();
                else System.out.println("Employee named '" + name + "' not found.");
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid numeric input. Returning to main menu.");
        }
    }

    public void mainMenu() {
        while (true) {
            System.out.println();
            System.out.println("=== Employee Management System ===");
            System.out.println("1. Add Manager");
            System.out.println("2. Add Developer");
            System.out.println("3. Display Employee Details");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String line = scanner.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer choice.");
                continue;
            }

            switch (choice) {
                case 1 -> createManager();
                case 2 -> createDeveloper();
                case 3 -> displayEmployeeDetails();
                case 4 -> displayAllEmployees();
                case 5 -> {
                    System.out.println("Exiting. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        // capacity 100 as an example
        ManagementSystem app = new ManagementSystem(100);
        app.mainMenu();
    }
}
