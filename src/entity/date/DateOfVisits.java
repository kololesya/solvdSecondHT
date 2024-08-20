package entity.date;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateOfVisits {
    private LocalDate inputDate;

    public LocalDate setLocalDate() {
        while (true) {
            try {
                System.out.print("Enter a year: ");
                Scanner sc = new Scanner(System.in);
                int year = sc.nextInt();
                System.out.print("Enter a month: ");
                int month = sc.nextInt();
                System.out.print("Enter a day: ");
                int day = sc.nextInt();
                inputDate = LocalDate.of(year, month, day);
                System.out.println("The entered date is valid.");
                break;
            } catch (DateTimeException e) {
                System.out.println("Invalid date format. Please use the format yyyy-MM-dd.");
            }
        }
        return inputDate;
    }

    public LocalDate getDateOfVisit() {
        return inputDate;
    }

    @Override
    public String toString() {
        return "Date of visit: " +
                inputDate;
    }
}