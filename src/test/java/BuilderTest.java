import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import student.Builder;
import student.IEmployee;
import student.ITimeCard;


public class BuilderTest {
    @Test
    public void testBuildHourlyEmployeeFromCSV() {
        IEmployee employee = Builder.buildEmployeeFromCSV("HOURLY,John Doe,12345,15.00,100.0,1000.00,100.00");
        assertEquals("John Doe", employee.getName());
    }

    @Test
    public void testBuildTimeCardFromCSV() {
        ITimeCard timeCard = Builder.buildTimeCardFromCSV("12345,40");
        assertEquals("12345", timeCard.getEmployeeID());
        assertEquals(40, timeCard.getHoursWorked());
    }
}