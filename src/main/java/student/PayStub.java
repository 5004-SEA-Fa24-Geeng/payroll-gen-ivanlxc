package student;

public class PayStub implements IPayStub {
    /** The name of the employee. */
    private String employeeName;
    /** The net pay after taxes and deductions. */
    private double netPay;
    /** The amount of taxes paid for the pay period. */
    private double taxesPaid;
    /** The year-to-date earnings of the employee. */
    private double ytdEarnings;
    /** The year-to-date taxes paid by the employee. */
    private double ytdTaxesPaid;

    /**
     * Constructs a PayStub object.
     *
     * @param employeeName The name of the employee.
     * @param netPay The net pay for the pay period.
     * @param taxesPaid The total taxes paid during this pay period.
     * @param ytdEarnings The year-to-date earnings.
     * @param ytdTaxesPaid The year-to-date taxes paid.
     */
    public PayStub(String employeeName, double netPay, double taxesPaid, double ytdEarnings, double ytdTaxesPaid) {
        this.employeeName = employeeName;
        this.netPay = netPay;
        this.taxesPaid = taxesPaid;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
    }

    @Override
    public double getPay() {
        return netPay;
    }

    @Override
    public double getTaxesPaid() {
        return taxesPaid;
    }

    @Override
    public String toCSV() {
        return employeeName + "," + netPay + "," + taxesPaid + "," + ytdEarnings + "," + ytdTaxesPaid;
    }
}

