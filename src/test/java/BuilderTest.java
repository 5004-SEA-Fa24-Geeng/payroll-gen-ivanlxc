package student;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BuilderTest {
    @Test
    public void testBuildEmployeeFromCSV_Hourly() {
        IEmployee emp = Builder.buildEmployeeFromCSV("HOURLY,John Doe,12345,15.00,100.0,1000.00,100.00");
        assertEquals("John Doe", emp.getName());
        assertTrue(emp instanceof HourlyEmployee);
    }

    @Test
    public void testBuildEmployeeFromCSV_Salary() {
        IEmployee emp = Builder.buildEmployeeFromCSV("SALARY,Jane Doe,67890,50000.00,200.0,5000.00,500.00");
        assertEquals("Jane Doe", emp.getName());
        assertTrue(emp instanceof SalaryEmployee);
    }
}
