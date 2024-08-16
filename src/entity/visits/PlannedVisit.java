package entity.visits;

import entity.date.DateOfVisits;
import entity.users.Patient;
import entity.users.Specialist;

import java.time.LocalDate;

public class PlannedVisit extends Visits{

    public PlannedVisit(Patient patient, Specialist spec, DateOfVisits visitDate){
        super(patient, spec, visitDate);
    }

    public String nameSpecialist (PlannedVisit plannedVisit){
        String fullName = plannedVisit.specialist.getFirstName() + " " + plannedVisit.specialist.getLastName();
        return fullName;
    }

    public LocalDate plannedDate (PlannedVisit plannedVisit){
        LocalDate date = plannedVisit.date.getLocalDate();
        return date;
    }

    @Override
    public String toString() {
        return "Planned visit: " +
                " " + patient.toString() +
                ", " + specialist.toString() +
                ", " + date.toString();
    }
}