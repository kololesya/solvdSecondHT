package entities.vehicle;

import java.time.LocalDate;

public interface Insurable {
    void insure(String startDate, String endDate);
    //boolean checkInsurance(String serviceDate);
}
