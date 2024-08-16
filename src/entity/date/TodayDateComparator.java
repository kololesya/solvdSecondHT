package entity.date;

import java.time.LocalDate;

class TodayDateComparator extends DateComparator {
    @Override
    public void compare(LocalDate date) {
        if (date.isEqual(currentDate)) {
            System.out.println("The entered date is today.");
        }
    }
}
