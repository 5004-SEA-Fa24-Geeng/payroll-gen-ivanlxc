package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalaryEmployee extends Employee {
    public SalaryEmployee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
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
        return roundToTwoDecimals(payRate / 24);
    }

    @Override
    public IPayStub runPayroll(double hoursWorked) {
        double grossPay = calculateGrossPay(0);
        double taxableIncome = grossPay - pretaxDeductions;
        final double TAX_RATE = 0.2265;     // the overall tax rate is 22.65% according to the IPayStub document
        double tax = roundToTwoDecimals(taxableIncome * TAX_RATE);
        double netPay = roundToTwoDecimals(taxableIncome - tax);

        ytdEarnings = roundToTwoDecimals(ytdEarnings + netPay);
        ytdTaxesPaid = roundToTwoDecimals(ytdTaxesPaid + tax);

        return new PayStub(name, netPay, tax, ytdEarnings, ytdTaxesPaid);
    }
}
