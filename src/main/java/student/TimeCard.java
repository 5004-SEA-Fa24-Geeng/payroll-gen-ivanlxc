package student;

public class TimeCard implements ITimeCard {
    private String employeeID;
    private double hoursWorked;

    public TimeCard(String employeeID, double hoursWorked) {
        this.employeeID = employeeID;
        this.hoursWorked = hoursWorked;
    }

    public String getEmployeeID() { return employeeID; }
    public double getHoursWorked() { return hoursWorked; }
}
