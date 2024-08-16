package entity.date;

import java.time.LocalDate;

class FutureDateComparator extends DateComparator {
    @Override
    public void compare(LocalDate date) {
        if (date.isAfter(currentDate)) {
            System.out.println("The entered date is in the future.");
        }
    }
}
