package entity.visits;

import java.time.LocalDate;
import java.util.Scanner;

public class DateOfVisits {
    private LocalDate localDate;

    public LocalDate setLocalDate() {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        localDate = LocalDate.of(year,month,day);
        return localDate;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    @Override
    public String toString() {
        return "Date of visit: " +
                localDate;
    }
}
