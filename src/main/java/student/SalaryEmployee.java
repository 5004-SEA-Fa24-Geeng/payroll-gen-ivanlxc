package student;

public class SalaryEmployee extends Employee {
    public SalaryEmployee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    public String getEmployeeType() { return "SALARY"; }

    protected double calculateGrossPay(double hoursWorked) {
        return payRate / 24; // 每月两次发薪
    }

    public String toCSV() {
        return super.toCSV();
    }
}
