package entity.visits;

import entity.date.DateOfVisits;
import entity.users.Patient;
import entity.users.Specialist;

public class CompletedVisit extends Visits{
    private PlannedVisit[] plannedVisits;
    protected boolean isOnTheListOfCompleted;

    public CompletedVisit(Patient patient, Specialist specialist, DateOfVisits date) {
        super(patient, specialist, date);
    }

    public boolean isOnTheListOfCompleted() {
        return isOnTheListOfCompleted;
    }

    public void setOnTheListOfCompleted(boolean onTheListOfCompleted) {
        isOnTheListOfCompleted = onTheListOfCompleted;
    }

//    public Visits[] completedVisits(boolean isOnTheListOfCompleted, PlannedVisit[] plannedVisits){
//        CompletedVisit[] completedVisits = new CompletedVisit[plannedVisits.length];
//        for(int i = 0; i < plannedVisits.length; i++){
//            if(plannedVisits[i].getDate().equals(localDate)){
//                if(isOnTheListOfCompleted(true)){
//                    plannedVisits[i] = completedVisits[i];
//                }
//            }
//        }
//        return completedVisits;
//    }
}
