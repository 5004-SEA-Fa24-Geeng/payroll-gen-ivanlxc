import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import student.PayStub;

public class PayStubTest {
    @Test
    public void testPayStub() {
        PayStub stub = new PayStub("Xingchen Liu", 600.00, 120.00, 5000.00, 1000.00);
        assertEquals(600.00, stub.getPay());
        assertEquals(120.00, stub.getTaxesPaid());
        assertEquals("Xingchen Liu,600.0,120.0,5000.0,1000.0", stub.toCSV());
    }
}
