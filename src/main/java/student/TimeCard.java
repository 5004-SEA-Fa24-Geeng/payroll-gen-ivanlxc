package student;

public class TimeCard implements ITimeCard {
    /** The employee id number*/
    private String employeeID;
    /** The employee's worked hours. */
    private double hoursWorked;
    /**
     * Constructs a TimeCard object representing an employee's recorded work hours.
     *
     * @param employeeID The unique identifier of the employee associated with this time card.
     * @param hoursWorked The total number of hours worked in the pay period.
     *                    Must be non-negative, otherwise an exception is thrown.
     * @throws IllegalArgumentException If the hours worked is negative.
     */
    public TimeCard(String employeeID, double hoursWorked) {
        if (hoursWorked < 0) {
            throw new IllegalArgumentException("Invalid hours worked");
        }
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
