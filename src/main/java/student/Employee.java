package student;

import student.IEmployee;

public abstract class Employee implements IEmployee {
    protected String name, id;
    protected double payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions;

    public Employee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }

    public String getName() { return name; }
    public String getID() { return id; }
    public double getPayRate() { return payRate; }
    public double getYTDEarnings() { return ytdEarnings; }
    public double getYTDTaxesPaid() { return ytdTaxesPaid; }
    public double getPretaxDeductions() { return pretaxDeductions; }


    protected abstract double calculateGrossPay(double hoursWorked);


    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) {
            return null; // 无效工时，跳过
        }

        double grossPay = calculateGrossPay(hoursWorked);
        double taxablePay = grossPay - pretaxDeductions; // **先扣除 pretaxDeductions**

        // **如果 pretaxDeductions 超过 grossPay，确保 taxablePay 不会变成负数**
        if (taxablePay < 0) {
            taxablePay = 0;
        }

        double tax = taxablePay * 0.20; // **或者 0.2265**
        double netPay = taxablePay - tax;

        ytdEarnings += grossPay;
        ytdTaxesPaid += tax;

        return new PayStub(name, netPay, tax, ytdEarnings, ytdTaxesPaid);
    }

    public String toCSV() {
        return getEmployeeType() + "," + name + "," + id + "," + payRate + "," + pretaxDeductions + "," + ytdEarnings + "," + ytdTaxesPaid;
    }

}
