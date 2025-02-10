package student;

public class HourlyEmployee extends Employee {
    public HourlyEmployee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    @Override
    public String getEmployeeType() {
        return "HOURLY";
    }

    @Override
    public double calculateGrossPay(double hoursWorked) {
        if (hoursWorked <= 40) {
            return hoursWorked * payRate;
        } else {
            return 40 * payRate + (hoursWorked - 40) * payRate * 1.5;
        }
    }

    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) return null;

        double grossPay = calculateGrossPay(hoursWorked);
        double taxableIncome = grossPay - pretaxDeductions;
        final double TAX_RATE = 0.2265;     // the overall tax rate is 22.65% according to the IPayStub document
        double tax = taxableIncome * TAX_RATE;
        double netPay = taxableIncome - tax;

        ytdEarnings += grossPay;
        ytdTaxesPaid += tax;

        return new PayStub(name, netPay, tax, ytdEarnings, ytdTaxesPaid);
    }
}
