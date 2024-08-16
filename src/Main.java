import entity.accounting.BillsForPeriod;
import entity.accounting.Salary;
import entity.users.Patient;
import entity.users.Specialist;
import entity.date.DateOfVisits;
import entity.visits.PlannedVisit;
import entity.visits.Schedule;

import static java.time.Month.AUGUST;

public class Main {
    public static void main(String[] args) {

        Patient patientFirst = new Patient("Anna", "Ivanova", 32, 'f');
        Specialist psycholog = new Specialist(1001, "Monika", "Kopij", "psycholog");
        Specialist neurolog = new Specialist(1002, "Anna", "Maj", "neurolog");

        DateOfVisits date = new DateOfVisits();
        date.setLocalDate();
        PlannedVisit ivanovaToKopij = new PlannedVisit(patientFirst, psycholog, date);

        DateOfVisits date1 = new DateOfVisits();
        date1.setLocalDate();
        PlannedVisit ivanova2ToKopij = new PlannedVisit(patientFirst, psycholog, date1);

        DateOfVisits date2 = new DateOfVisits();
        date2.setLocalDate();
        PlannedVisit ivanova3ToMaj = new PlannedVisit(patientFirst, neurolog, date2);

        PlannedVisit[] schedule = {ivanovaToKopij, ivanova2ToKopij, ivanova3ToMaj};

        System.out.println(Schedule.scheduleByDate(schedule, "2024-05-06"));

        System.out.println(Schedule.scheduleBySpecialist(schedule, "Monika Kopij"));

        System.out.println(BillsForPeriod.billsBySpecId(1001, schedule, AUGUST));

        System.out.println(Salary.getSalaryRate(1001, schedule, AUGUST));
    }
}