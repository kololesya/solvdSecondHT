package entity.visits;

import entity.users.Patient;
import entity.users.Specialist;

import java.time.LocalDate;

public class PlannedVisit {
    private Patient patient;
    private Specialist specialist;
    private DateOfVisits date;

    public PlannedVisit(Patient patient, Specialist spec, DateOfVisits visitDate){
        this.patient = patient;
        this.specialist = spec;
        this.date = visitDate;
    }

    public String nameSpecialist (PlannedVisit plannedVisit){
        String fullName = plannedVisit.specialist.getFirstName() + " " + plannedVisit.specialist.getLastName();
        return fullName;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getSpecialization() {
        return specialist.getSpecialization();
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public DateOfVisits getDate() {
        return date;
    }

    public void setDate(DateOfVisits date) {
        this.date = date;
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
