package entity.visits;

import entity.date.DateOfVisits;

import java.util.ArrayList;

public class Schedule {
    Visit visit;
    Visit [] visits;

    public Visit[] getVisits() {
        return visits;
    }

    public Visit getVisit() {
        return visit;
    }

    public static ArrayList<DateOfVisits> scheduledDatesBySpecialist(Visit[] plannedVisits, String fullName){
        ArrayList<DateOfVisits> scheduleBySpecialist = new ArrayList<>();
        for (Visit visit : plannedVisits) {
            if (!visit.isCompleted()){
                if (visit.getSpecialist().getFullName().equals(fullName)){
                    scheduleBySpecialist.add(visit.getDateOfVisit());
                }
            }
        }
        return scheduleBySpecialist;
    }

    public static ArrayList<String> scheduleForSpecialistByDate(Visit [] schedule, String date){
        ArrayList<String> scheduleByDate = new ArrayList<>();
        for (int i = 0; i < schedule.length; i++) {
            if(schedule[i].getDateOfVisit().getDateOfVisit().toString().equals(date)) {
                scheduleByDate.add(schedule[i].getSpecialist().getFullName());
            }
        }
        return scheduleByDate;
    }
}