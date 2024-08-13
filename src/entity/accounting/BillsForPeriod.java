package entity.accounting;

import entity.users.Specialist;
import entity.visits.PlannedVisit;

import java.time.Month;

public class BillsForPeriod {
    private Bill bill;
    private Specialist spec;

    public static int billsBySpecId(int specId, PlannedVisit[] schedule, Month month){

        int sum = 0;
        for (int j = 0; j < schedule.length; j++) {
            if(schedule[j].getDate().getLocalDate().getMonth().equals(month)){
                if(schedule[j].getSpecialist().getSpecID() == specId){
                    if(schedule[j].getSpecialist().getSpecialization().equalsIgnoreCase("psycholog")){
                        sum += Bill.priceForPsycholog();
                    } else {
                        sum += Bill.priceForOtherSpecialists();
                    }

                }
            }
        }
        return sum;
    }
}
