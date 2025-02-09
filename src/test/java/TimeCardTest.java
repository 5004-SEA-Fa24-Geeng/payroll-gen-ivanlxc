import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import student.TimeCard;

public class TimeCardTest {
    @Test
    public void testGetEmployeeID() {
        TimeCard timeCard = new TimeCard("12345", 40);
        assertEquals("12345", timeCard.getEmployeeID());
    }

    @Test
    public void testGetHoursWorked() {
        TimeCard timeCard = new TimeCard("12345", 40);
        assertEquals(40, timeCard.getHoursWorked());
    }
}
