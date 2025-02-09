package student;

public class HourlyEmployee extends Employee {
    public HourlyEmployee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    public String getEmployeeType() { return "HOURLY"; }

    protected double calculateGrossPay(double hoursWorked) {
        if (hoursWorked <= 40) {
            return hoursWorked * payRate; // 正常工资计算
        } else {
            return (40 * payRate) + ((hoursWorked - 40) * payRate * 1.5); // 加班工资
        }
    }
    public String toCSV() {
        return super.toCSV();
    }
}
