package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalaryEmployee extends Employee {
    /**
     * Constructs a SalaryEmployee object.
     *
     * @param name The name of the employee.
     * @param id The unique ID of the employee.
     * @param payRate The annual salary of the employee.
     * @param ytdEarnings The year-to-date earnings of the employee.
     * @param ytdTaxesPaid The year-to-date taxes paid by the employee.
     * @param pretaxDeductions The total pre-tax deductions applied to the employee's salary.
     */
    public SalaryEmployee(String name, String id, double payRate, double ytdEarnings,
                          double ytdTaxesPaid, double pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    private double roundToTwoDecimals(double value) {
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }


    @Override
    public String getEmployeeType() {
        return "SALARY";
    }

    @Override
    public double calculateGrossPay(double hoursWorked) {
        return roundToTwoDecimals(getPayRate() / 24);
    }

    @Override
    public IPayStub runPayroll(double hoursWorked) {

        double grossPay = roundToTwoDecimals(calculateGrossPay(hoursWorked));
        double taxableIncome = grossPay - getPretaxDeductions();
        final double taxRate = 0.2265;     // the overall tax rate is 22.65% according to the IPayStub document
        double tax = roundToTwoDecimals(taxableIncome * taxRate);
        double netPay = roundToTwoDecimals(taxableIncome - tax);


        if (hoursWorked > 0) {
            double newYTDEarnings = roundToTwoDecimals(getYTDEarnings() + netPay);
            double newYTDTaxesPaid = roundToTwoDecimals(getYTDTaxesPaid() + tax);
            setYTDEarnings(newYTDEarnings);
            setYTDTaxesPaid(newYTDTaxesPaid);
        }

        return new PayStub(getName(), netPay, tax,
                roundToTwoDecimals(getYTDEarnings()), roundToTwoDecimals(getYTDTaxesPaid()));
    }
}
