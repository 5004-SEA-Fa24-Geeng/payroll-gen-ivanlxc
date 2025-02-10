package student;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
    private HourlyEmployee hourlyEmployee;
    private SalaryEmployee salaryEmployee;

    @BeforeEach
    public void setUp() {
        hourlyEmployee = new HourlyEmployee("Xingchen Liu", "12345", 15.00, 1000.0, 100.0, 50.0);
        salaryEmployee = new SalaryEmployee("Ivan Liu", "67890", 50000.00, 3000.0, 500.0, 200.0);
    }

    @Test
    public void testGetName() {
        assertEquals("Xingchen Liu", hourlyEmployee.getName());
        assertEquals("Ivan Liu", salaryEmployee.getName());
    }

    @Test
    public void testGetID() {
        assertEquals("12345", hourlyEmployee.getID());
        assertEquals("67890", salaryEmployee.getID());
    }

    @Test
    public void testGetPayRate() {
        assertEquals(15.00, hourlyEmployee.getPayRate());
        assertEquals(50000.00, salaryEmployee.getPayRate());
    }

    @Test
    public void testGetYTDEarnings() {
        assertEquals(1000.0, hourlyEmployee.getYTDEarnings());
        assertEquals(3000.0, salaryEmployee.getYTDEarnings());
    }

    @Test
    public void testGetYTDTaxesPaid() {
        assertEquals(100.0, hourlyEmployee.getYTDTaxesPaid());
        assertEquals(500.0, salaryEmployee.getYTDTaxesPaid());
    }

    @Test
    public void testGetPretaxDeductions() {
        assertEquals(50.0, hourlyEmployee.getPretaxDeductions());
        assertEquals(200.0, salaryEmployee.getPretaxDeductions());
    }
}

