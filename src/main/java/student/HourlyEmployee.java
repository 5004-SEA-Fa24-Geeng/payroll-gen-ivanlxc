package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HourlyEmployee extends Employee {
    public HourlyEmployee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    private double roundToTwoDecimals(double value) {
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
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
            return roundToTwoDecimals(40 * payRate + (hoursWorked - 40) * payRate * 1.5);
        }
    }

    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) return null;

        double grossPay = roundToTwoDecimals(calculateGrossPay(hoursWorked));
        double taxableIncome = grossPay - pretaxDeductions;
        final double TAX_RATE = 0.2265;     // the overall tax rate is 22.65% according to the IPayStub document
        double tax = roundToTwoDecimals(taxableIncome * TAX_RATE);
        double netPay = roundToTwoDecimals(taxableIncome - tax);

        ytdEarnings = roundToTwoDecimals(ytdEarnings + netPay);
        ytdTaxesPaid = roundToTwoDecimals(ytdTaxesPaid + tax);

        return new PayStub(name, netPay, tax, ytdEarnings, ytdTaxesPaid);
    }
}
