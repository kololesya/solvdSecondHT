package entities.people;

public interface EmployeeManagement <T>{

    Employee[] addEmployeeToDepartment(Employee[] originalArray, Employee employee);
    Employee[] removeEmployee(Employee[] employees, String fullName);

    double calculateTotalSalary();
}
