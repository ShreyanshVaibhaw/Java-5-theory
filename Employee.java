/**
 * Employee.java
 * Base class representing a generic employee.
 */

public class Employee {
    protected int employeeId;
    protected String name;
    protected double salary;

    public Employee() {}

    public Employee(int employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    // getters
    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    // setters
    public void setName(String name) { this.name = name; }
    public void setSalary(double salary) { this.salary = salary; }

    /**
     * calculateBonus - base implementation (can be overridden).
     * Default: 10% of salary
     */
    public double calculateBonus() {
        return salary * 0.10;
    }

    /**
     * displayDetails - show employee info. Subclasses should call super.displayDetails()
     * and then display subclass-specific info.
     */
    public void displayDetails() {
        System.out.printf("Employee ID: %d, Name: %s, Salary: %.2f, Bonus: %.2f%n",
                          employeeId, name, salary, calculateBonus());
    }
}
