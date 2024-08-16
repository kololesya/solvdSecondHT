package entity.visits;

import entity.date.DateOfVisits;
import entity.users.Patient;
import entity.users.Specialist;

public class Visits {
    Patient patient;
    Specialist specialist;
    DateOfVisits date;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    public DateOfVisits getDate() {
        return date;
    }

    public void setDate(DateOfVisits date) {
        this.date = date;
    }

    public Visits(Patient patient, Specialist specialist, DateOfVisits date) {
        this.patient = patient;
        this.specialist = specialist;
        this.date = date;
    }
}
