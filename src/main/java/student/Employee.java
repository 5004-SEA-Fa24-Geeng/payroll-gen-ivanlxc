package student;

public abstract class Employee implements IEmployee {
    protected String name;
    protected String id;
    protected double payRate;
    protected double ytdEarnings;
    protected double ytdTaxesPaid;
    protected double pretaxDeductions;

    public Employee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public double getPayRate() {
        return payRate;
    }

    @Override
    public double getYTDEarnings() {
        return ytdEarnings;
    }

    @Override
    public double getYTDTaxesPaid() {
        return ytdTaxesPaid;
    }

    @Override
    public double getPretaxDeductions() {
        return pretaxDeductions;
    }

    // 🚀 关键修改：实现 toCSV() 方法，让所有子类继承
    @Override
    public String toCSV() {
        return getEmployeeType() + "," + name + "," + id + "," + payRate + "," + pretaxDeductions + "," + ytdEarnings + "," + ytdTaxesPaid;
    }

    // 子类必须实现的方法
    public abstract String getEmployeeType();
    public abstract double calculateGrossPay(double hoursWorked);
    public abstract IPayStub runPayroll(double hoursWorked);
}

