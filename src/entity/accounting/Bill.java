package entity.accounting;

import entity.users.Specialist;
import entity.visits.Visit;

import java.time.Month;

import static java.time.Month.MAY;

public class Bill {
    private Specialist specialist;

    public static int priceForPsycholog (){
        return 50;
    }

    public static int priceForOtherSpecialists (){
        return 40;
    }

    public int Bill(Specialist specialist, int priceForPsycholog, int priceForOtherSpecialists) {
        this.specialist = specialist;
        if (specialist.getSpecialization().equalsIgnoreCase("psychologist")){
            return priceForPsycholog;
        }
        return priceForOtherSpecialists;
    }

    public static int billsByMonthForSpec(String fullNameOfSpec, Visit[] schedule, Month month){

        int sum = 0;
        for (int j = 0; j < schedule.length; j++) {
            if(schedule[j].isCompleted()){
                if(schedule[j].getDateOfVisit().getDateOfVisit().getMonth().equals(MAY)){
                    if(schedule[j].getSpecialist().getFullName().equals("Monika Kopij")){
                        if(schedule[j].getSpecialist().getSpecialization().equalsIgnoreCase("psychologist")){
                            sum += Bill.priceForPsycholog();
                        } else {
                            sum += Bill.priceForOtherSpecialists();
                        }
                    }
                }
            }
        }

        return sum;
    }
}
