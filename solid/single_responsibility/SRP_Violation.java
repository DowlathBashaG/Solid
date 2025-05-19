package dowlath.io.solid.single_responsibility;

/**
 * Without SingleResponsibility Principle
 * This class violates SRP because it handles both salary calculation and report generation.
 */
// Violates SRP: This class has multiple responsibilities (salary calculation & report generation)

class Employee_1 {
    private String name;
    private double salary;

    public Employee_1(String name,double salary){
        this.name = name;
        this.salary = salary;
    }

    public double calculateSalary(){
        return salary * 1.2;  // Example salary calculation
    }

    public void generateReport(){
        System.out.println("Generating Employee Report ....");
    }
}

public class SRP_Violation {
    public static void main(String[] args) {
        Employee_1 emp = new Employee_1("Dowlath",5000);
        System.out.println("Salary .... : "+ emp.calculateSalary());
        emp.generateReport();
    }
}
