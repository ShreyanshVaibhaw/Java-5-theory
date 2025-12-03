public class Developer extends Employee {
    private String programmingLanguage;

    public Developer(int employeeId, String name, double salary, String programmingLanguage) {
        super(employeeId, name, salary);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() { return programmingLanguage; }
    public void setProgrammingLanguage(String programmingLanguage) { this.programmingLanguage = programmingLanguage; }

    @Override
    public double calculateBonus() {
        return salary * 0.12;
    }

    @Override
    public void displayDetails() {
        System.out.printf("Employee ID: %d, Name: %s, Language: %s, Salary: %.2f, Bonus: %.2f%n",
                          employeeId, name, programmingLanguage, salary, calculateBonus());
    }
}
