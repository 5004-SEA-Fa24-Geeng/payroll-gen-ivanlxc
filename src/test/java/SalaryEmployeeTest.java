package student;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SalaryEmployeeTest {
    private SalaryEmployee salaryEmployee;

    @BeforeEach
    public void setUp() {
        salaryEmployee = new SalaryEmployee("Ivan Liu", "67890", 50000.00, 3000.0, 500.0, 200.0);
    }

    @Test
    public void testCalculateGrossPay() {
        assertEquals(2083.33, salaryEmployee.calculateGrossPay(0), 0.01);
    }
}
