package student;

public class TimeCard implements ITimeCard {
    private String employeeID;
    private double hoursWorked;

    public TimeCard(String employeeID, double hoursWorked) {
        if (hoursWorked < 0) throw new IllegalArgumentException("Invalid hours worked");
        this.employeeID = employeeID;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getEmployeeID() {
        return employeeID;
    }

    @Override
    public double getHoursWorked() {
        return hoursWorked;
    }
}
