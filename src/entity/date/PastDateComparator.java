package entity.date;

import java.time.LocalDate;

class PastDateComparator extends DateComparator  {

    public void compare(LocalDate date) {
        if (date.isBefore(currentDate)) {
            System.out.println("The entered date is in the past.");
        }
    }
}
