package entity.visits;

import entity.date.DateOfVisits;
import entity.users.Employee;
import entity.users.Patient;
import entity.users.Specialist;

import java.time.LocalDate;

public class Visit {
    private Patient patient;
    private Specialist specialist;
    private DateOfVisits dateOfVisit;
    private boolean completed;

    public Visit(Patient patient, Specialist specialist, DateOfVisits date) {
        this.patient = patient;
        this.specialist = specialist;
        this.dateOfVisit = date;
        this.completed = false;
    }

    public Patient getPatient() {
        return patient;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public DateOfVisits getDateOfVisit() {
        return dateOfVisit;
    }

    public void completeVisit() {
        this.completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return "The patient's visit " + patient.getName()
                + " to the doctor " + specialist.getName()
                + " on " + dateOfVisit
                + (completed ? " (took place)" : " (did not take place)");
    }
}
