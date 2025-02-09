import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import student.HourlyEmployee;
import student.SalaryEmployee;
import student.PayStub;

public class EmployeeTest {
    private HourlyEmployee hourlyEmployee;
    private SalaryEmployee salaryEmployee;

    @BeforeEach
    public void setUp() {
        hourlyEmployee = new HourlyEmployee("John Doe", "12345", 15.00, 1000.0, 100.0, 50.0);
        salaryEmployee = new SalaryEmployee("Jane Doe", "67890", 50000.00, 3000.0, 500.0, 200.0);
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", hourlyEmployee.getName());
        assertEquals("Jane Doe", salaryEmployee.getName());
    }

    @Test
    public void testRunPayroll_Hourly_NoOvertime() {
        PayStub stub = (PayStub) hourlyEmployee.runPayroll(40);
        double expectedNetPay = (40 * 15.00 - 50.00) * 0.8; // 扣除 20% 税率
        assertEquals(expectedNetPay, stub.getPay(), 0.01);
    }

    @Test
    public void testRunPayroll_Hourly_WithOvertime() {
        PayStub stub = (PayStub) hourlyEmployee.runPayroll(45);
        double expectedNetPay = ((40 * 15.00) + (5 * 15.00 * 1.5) - 50.0) * 0.8;
        assertEquals(expectedNetPay, stub.getPay());
    }

    @Test
    public void testRunPayroll_Salary() {
        PayStub stub = (PayStub) salaryEmployee.runPayroll(0);
        double expectedNetPay = (50000.00/24 - 200.0) * 0.8;
        assertEquals(expectedNetPay, stub.getPay(), 0.01);
    }
}

