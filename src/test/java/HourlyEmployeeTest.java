package student;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HourlyEmployeeTest {
    private HourlyEmployee hourlyEmployee;

    @BeforeEach
    public void setUp() {
        hourlyEmployee = new HourlyEmployee("Xingchen Liu", "12345", 15.00, 1000.0, 100.0, 50.0);
    }

    @Test
    public void testCalculateGrossPay_NoOvertime() {
        assertEquals(600.00, hourlyEmployee.calculateGrossPay(40));
    }

    @Test
    public void testCalculateGrossPay_WithOvertime() {
        assertEquals(712.50, hourlyEmployee.calculateGrossPay(45));
    }
}
