import entity.accounting.Bill;
import entity.accounting.Salary;
import entity.users.Patient;
import entity.users.Specialist;
import entity.date.DateOfVisits;
import entity.visits.Schedule;
import entity.visits.Visit;

import java.util.ArrayList;

import static java.time.Month.AUGUST;
import static java.time.Month.MAY;

public class Main {
    public static void main(String[] args) {

        Patient patientFirst = new Patient("Anna Ivanova", 32);
        Patient patientSecond = new Patient("Iwona Mendrek", 11);
        Patient patientThird = new Patient("Karol Rodwald", 17);

        Specialist psychologist = new Specialist("Monika Kopij", "psychologist");
        Specialist neurolog = new Specialist("Anna Maj", "neurolog");
        Specialist speechTherapist = new Specialist("Maja Zgro", "speech therapist");

        DateOfVisits date = new DateOfVisits();
        date.setLocalDate();
        DateOfVisits date1 = new DateOfVisits();
        date1.setLocalDate();
        DateOfVisits date2 = new DateOfVisits();
        date2.setLocalDate();
        DateOfVisits date3 = new DateOfVisits();
        date3.setLocalDate();

        PsychologyCenter psychologyCenter = new PsychologyCenter();
//        psychologyCenter.bookVisit(patientFirst, psychologist, date);
//        psychologyCenter.bookVisit(patientSecond, neurolog, date1);
//        psychologyCenter.bookVisit(patientThird, speechTherapist, date2);
//        psychologyCenter.bookVisit(patientThird, psychologist, date3);

        Visit ivanovaToKopij = new Visit(patientFirst, psychologist, date);
        Visit mendrekToMaj = new Visit(patientSecond, neurolog, date1);
        Visit rodwaldToZgro = new Visit(patientThird, speechTherapist, date2);
        Visit rodwaldToKopij = new Visit(patientThird, psychologist, date3);
        Visit[] schedule = {ivanovaToKopij, mendrekToMaj, rodwaldToZgro, rodwaldToKopij};

        psychologyCenter.completeVisit(ivanovaToKopij);
        psychologyCenter.completeVisit(rodwaldToZgro);

        psychologyCenter.showAllVisits();

        System.out.println(Schedule.scheduleForSpecialistByDate(schedule, "2024-05-06"));

        System.out.println(Schedule.scheduledDatesBySpecialist(schedule, "Monika Kopij"));

        System.out.println(Bill.billsByMonthForSpec("Kopij", schedule, MAY));

        //System.out.println(Salary.getSalaryRate(1001, schedule, AUGUST));
    }
}