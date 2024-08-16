package entity.date;

import java.time.LocalDate;

abstract class DateComparator {
    protected LocalDate currentDate;

    public DateComparator() {
        this.currentDate = LocalDate.now();
    }

    public abstract void compare(LocalDate date);
}
