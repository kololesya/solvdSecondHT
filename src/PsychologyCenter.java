import entity.date.DateOfVisits;
import entity.users.Employee;
import entity.users.Patient;
import entity.users.Specialist;
import entity.visits.Visit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PsychologyCenter {
    private List<Visit> visits = new ArrayList<>();

//    public void bookVisit(Patient patient, Specialist specialist, DateOfVisits date) {
//        Visit visit = new Visit(patient, specialist, date);
//        visits.add(visit);
//        System.out.println("The appointment: " + visit + " is reserved.");
//    }

    public void completeVisit(Visit visit) {
        visit.completeVisit();
        System.out.println("The appointment: " + visit + "is completed");
    }

//    public void calculatePayrollForAllEmployees(List<Employee> employees) {
//        for (Employee employee : employees) {
//            double salary = Payroll.calculateSalary(employee);
//            System.out.println("Зарплата для " + employee.getName() + ": " + salary);
//        }
//    }

    public void showAllVisits() {
        for (Visit visit : visits) {
            System.out.println(visit);
        }
    }
}
