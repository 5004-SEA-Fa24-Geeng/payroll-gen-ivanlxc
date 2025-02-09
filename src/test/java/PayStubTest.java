import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import student.PayStub;


public class PayStubTest {
    @Test
    public void testGetPay() {
        PayStub stub = new PayStub("John Doe", 1000.00, 200.00, 5000.00, 1000.00);
        assertEquals(1000.00, stub.getPay());
    }

    @Test
    public void testToCSV() {
        PayStub stub = new PayStub("John Doe", 1000.00, 200.00, 5000.00, 1000.00);
        assertEquals("John Doe,1000.00,200.00,5000.00,1000.00", stub.toCSV());
    }
}
