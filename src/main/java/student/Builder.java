package student;

/** 
 * This is a static class (essentially functions) that will help you build objects from CSV strings.
 * These objects are then used in the rest of the program. Often these builders are associated
 * with the objects themselves and the concept of a factory, but we placed
 * them here to keep the code clean (and to help guide you).
 */
public final class Builder {
    
    private Builder() {
    }


     /**
     * Builds an employee object from a CSV string.
     * 
     * You may end up checking the type of employee (hourly or salary) by looking at the first
     * element of the CSV string. Then building an object specific to that type.
     * 
     * @param csv the CSV string
     * @return the employee object
     */
    public static IEmployee buildEmployeeFromCSV(String csv) {
        String[] parts = csv.split(",");
        if (parts.length != 7) throw new IllegalArgumentException("Invalid Employee CSV format");

        if (parts[0].equals("HOURLY")) {
            return new HourlyEmployee(parts[1], parts[2], Double.parseDouble(parts[3]),
                    Double.parseDouble(parts[4]), Double.parseDouble(parts[5]), Double.parseDouble(parts[6]));
        } else {
            return new SalaryEmployee(parts[1], parts[2], Double.parseDouble(parts[3]),
                    Double.parseDouble(parts[4]), Double.parseDouble(parts[5]), Double.parseDouble(parts[6]));
        }
    }



   /**
     * Converts a TimeCard from a CSV String.
     * 
     * @param csv csv string
     * @return a TimeCard object
     */
    public static ITimeCard buildTimeCardFromCSV(String csv) {
        String[] parts = csv.split(",");
        if (parts.length != 2) throw new IllegalArgumentException("Invalid TimeCard CSV format");

        return new TimeCard(parts[0], Double.parseDouble(parts[1]));
    }
}
