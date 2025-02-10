package student;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.nio.file.*;
import java.io.*;

public class PayrollGeneratorTest {
    @Test
    public void testPayrollGeneratorMain() throws IOException {
        Path employeeFile = Files.createTempFile("employees", ".csv");
        Path timeCardFile = Files.createTempFile("time_cards", ".csv");
        Path payStubFile = Files.createTempFile("pay_stubs", ".csv");

        Files.writeString(employeeFile, "HOURLY,Xingchen Liu,12345,15.00,100.0,1000.00,100.00\n");
        Files.writeString(timeCardFile, "12345,40\n");

        String[] args = {"-e", employeeFile.toString(), "-t", timeCardFile.toString(), "-o", payStubFile.toString()};
        PayrollGenerator.main(args);

        String output = Files.readString(payStubFile);
        assertTrue(output.contains("Xingchen Liu,600.00"));
    }
}
