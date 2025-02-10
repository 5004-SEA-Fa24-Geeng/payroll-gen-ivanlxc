package student;

public class SalaryEmployee extends Employee {
    public SalaryEmployee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    @Override
    public String getEmployeeType() {
        return "SALARY";
    }

    @Override
    public double calculateGrossPay(double hoursWorked) {
        return payRate / 24;
    }

    @Override
    public IPayStub runPayroll(double hoursWorked) {
        double grossPay = calculateGrossPay(0);
        double taxableIncome = grossPay - pretaxDeductions;
        final double TAX_RATE = 0.2265;     // the overall tax rate is 22.65% according to the IPayStub document
        double tax = taxableIncome * TAX_RATE;
        double netPay = taxableIncome - tax;

        ytdEarnings += grossPay;
        ytdTaxesPaid += tax;

        return new PayStub(name, netPay, tax, ytdEarnings, ytdTaxesPaid);
    }
}
