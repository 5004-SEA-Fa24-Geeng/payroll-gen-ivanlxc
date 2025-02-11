import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import student.TimeCard;

public class TimeCardTest {
    @Test
    public void testTimeCardConstructor() {
        TimeCard tc = new TimeCard("12345", 40);
        assertEquals("12345", tc.getEmployeeID());
        assertEquals(40, tc.getHoursWorked());
    }


}
