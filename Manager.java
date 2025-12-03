public class Manager extends Employee {
    private String department;

    public Manager(int employeeId, String name, double salary, String department) {
        super(employeeId, name, salary);
        this.department = department;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public double calculateBonus() {
        return salary * 0.15;
    }

    @Override
    public void displayDetails() {
        System.out.printf("Employee ID: %d, Name: %s, Department: %s, Salary: %.2f, Bonus: %.2f%n",
                          employeeId, name, department, salary, calculateBonus());
    }
}
