package entities.utils;

import entities.vehicle.Vehicle;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ServiceUtils {
    public static boolean isValidDate(String dateStr, String format) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(format);
        try {
            LocalDate.parse(dateStr, dateFormatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static int calculateCarAge(int manufacturingYear) {
        int currentYear = LocalDate.now().getYear();
        return currentYear - manufacturingYear;
    }

    public static <T extends Vehicle> void vehicleSummary(T vehicle) {
        System.out.println("Vehicle Summary: " + vehicle.toString());
    }
}
