package student;

public class PayStub implements IPayStub {
    private String employeeName;
    private double netPay;
    private double taxesPaid;
    private double ytdEarnings;
    private double ytdTaxesPaid;

    public PayStub(String employeeName, double netPay, double taxesPaid, double ytdEarnings, double ytdTaxesPaid) {
        this.employeeName = employeeName;
        this.netPay = netPay;
        this.taxesPaid = taxesPaid;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
    }

    public double getPay() {
        return netPay;
    }
    public double getTaxesPaid() { return taxesPaid; }
    public String toCSV() {
        return employeeName + "," + netPay + "," + taxesPaid + "," + ytdEarnings + "," + ytdTaxesPaid;
    }
}
