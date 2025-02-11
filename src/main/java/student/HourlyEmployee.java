package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HourlyEmployee extends Employee {
    /**
     * Constructs an HourlyEmployee object.
     *
     * @param name The name of the employee.
     * @param id The employee's unique ID.
     * @param payRate The hourly pay rate.
     * @param ytdEarnings Year-to-date earnings.
     * @param ytdTaxesPaid Year-to-date taxes paid.
     * @param pretaxDeductions The amount deducted before tax.
     */
    public HourlyEmployee(String name, String id, double payRate, double ytdEarnings,
                          double ytdTaxesPaid, double pretaxDeductions) {
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
            return hoursWorked * getPayRate();
        } else {
            return roundToTwoDecimals(40 * getPayRate() + (hoursWorked - 40) * getPayRate() * 1.5);
        }
    }

    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) {
            return null;
        }

        double grossPay = roundToTwoDecimals(calculateGrossPay(hoursWorked));
        double taxableIncome = grossPay - getPretaxDeductions();
        final double taxRate = 0.2265;     // the overall tax rate is 22.65% according to the IPayStub document
        double tax = roundToTwoDecimals(taxableIncome * taxRate);
        double netPay = roundToTwoDecimals(taxableIncome - tax);


//        double ytdEarnings = getYTDEarnings();
//        double ytdTaxesPaid = getYTDTaxesPaid();

        double previousYTDEarnings = getYTDEarnings();
        double previousYTDTaxesPaid = getYTDTaxesPaid();

        double newYTDEarnings = roundToTwoDecimals(previousYTDEarnings + netPay);
        double newYTDTaxesPaid = roundToTwoDecimals(previousYTDTaxesPaid + tax);

        setYTDEarnings(newYTDEarnings);
        setYTDTaxesPaid(newYTDTaxesPaid);

        return new PayStub(getName(), netPay, tax,
                roundToTwoDecimals(getYTDEarnings()), roundToTwoDecimals(getYTDTaxesPaid()));
    }
}
