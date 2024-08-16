package entity.visits;

import java.time.LocalDate;
import java.util.ArrayList;

public class Schedule {
    PlannedVisit [] plannedVisits;

    public static ArrayList<LocalDate> scheduleBySpecialist(PlannedVisit [] plannedVisits, String fullName){
        ArrayList<LocalDate> scheduleBySpecialist = new ArrayList<>();
        for (int i = 0; i < plannedVisits.length; i++) {
            if (plannedVisits[i].nameSpecialist(plannedVisits[i]).equals(fullName)){
                scheduleBySpecialist.add(plannedVisits[i].plannedDate(plannedVisits[i]));
            }
        }
        return scheduleBySpecialist;
    }

    public static ArrayList<String> scheduleByDate(PlannedVisit [] schedule, String date){
        ArrayList<String> scheduleByDate = new ArrayList<>();
        for (int i = 0; i < schedule.length; i++) {
            if(schedule[i].plannedDate(schedule[i]).toString().equals(date)) {
                scheduleByDate.add(schedule[i].nameSpecialist(schedule[i]));
            }
        }
        return scheduleByDate;
    }
}