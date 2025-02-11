package student;

public abstract class Employee implements IEmployee {
    /** The name of the employee. */
    private String name;

    /** The unique employee ID. */
    private String id;

    /** The pay rate of the employee (hourly or salary). */
    private double payRate;

    /** The year-to-date earnings of the employee. */
    private double ytdEarnings;

    /** The year-to-date taxes paid by the employee. */
    private double ytdTaxesPaid;

    /** The amount deducted before tax. */
    private double pretaxDeductions;

    /**
     * Constructor for an Employee.
     *
     * @param name The employee's name.
     * @param id The employee's unique ID.
     * @param payRate The pay rate (hourly or salary).
     * @param ytdEarnings Year-to-date earnings.
     * @param ytdTaxesPaid Year-to-date taxes paid.
     * @param pretaxDeductions Amount deducted before tax.
     */
    public Employee(String name, String id, double payRate, double ytdEarnings,
                    double ytdTaxesPaid, double pretaxDeductions) {
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }

    protected void setYTDEarnings(double newEarnings) {
        this.ytdEarnings = newEarnings;
    }

    protected void setYTDTaxesPaid(double newTaxesPaid) {
        this.ytdTaxesPaid = newTaxesPaid;
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

    @Override
    public String toCSV() {
        return getEmployeeType() + "," + getName() + "," + getID() + "," + getPayRate() + ","
                + getPretaxDeductions() + "," + getYTDEarnings() + "," + getYTDTaxesPaid();
    }

    /**
     * Gets the type of the employee (Hourly or Salary).
     *
     * @return The employee type.
     */
    public abstract String getEmployeeType();

    /**
     * Calculates the employee's gross pay based on hours worked.
     *
     * @param hoursWorked The number of hours worked.
     * @return The calculated gross pay.
     */
    public abstract double calculateGrossPay(double hoursWorked);

    /**
     * Processes payroll for the employee.
     *
     * @param hoursWorked the hours worked for the pay period
     * @return A PayStub object containing the payroll details.
     */
    public abstract IPayStub runPayroll(double hoursWorked);
}

