package dowlath.io.solid.single_responsibility;

class Employee_2{
    private String name;
    private double salary;

    Employee_2(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

}

// Responsible for salary calculation
class SalaryCalculator{
    public double calculateSalary(Employee_2 employee){
        return employee.getSalary() * 2;
    }
}

// Responsible for report generation
class ReportGenerator{
    public void generateReport(Employee_2 employee){
        System.out.println("Generating employee report for ... :  "+ employee.getName());
    }
}

public class SRP_WithOut_Violation {
    public static void main(String[] args) {
        Employee_2 emp = new Employee_2("Dowlath", 5000);
        SalaryCalculator salaryCalculator = new SalaryCalculator();
        ReportGenerator reportGenerator = new ReportGenerator();

        reportGenerator.generateReport(emp);
        System.out.println("Salary ... : "+salaryCalculator.calculateSalary(emp));
    }

}
