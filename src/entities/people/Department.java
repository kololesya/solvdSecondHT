package entities.people;

import entities.CarServiceException;
import entities.SalaryCalculable;
import entities.utils.ServiceUtils;
import services.ServiceCost;

import java.util.*;

import static entities.utils.ServiceUtils.*;

public class Department implements SalaryCalculable {
    private String departmentName;
    private Set<Employee> employees;
    private Set<ServiceCost> serviceCosts;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new HashSet<>();
        this.serviceCosts = new HashSet<>();
    }

    public Department(String departmentName, Set<Employee> employees) {
        this.departmentName = departmentName;
        this.employees = employees != null ? employees : new HashSet<>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<ServiceCost> getServiceCosts() {
        return serviceCosts;
    }

    public void setServiceCosts(Set<ServiceCost> serviceCosts) {
        this.serviceCosts = serviceCosts;
    }

    @Override
    public double calculateTotalSalary(){
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.calculateSalary();
        }
        return totalSalary;
    }

    public void printEmployees(){
        for(Employee employee : employees){
            System.out.println(employee.toString());
        }
    }

    public void removeEmployee(Employee employee) {
        setEmployees(removeElementFromSet(employees, employee));
    }

    public void addEmployee(Employee employee){
        addElementToSet(employees, employee);
    }

    @Override
    public String toString() {
        return "Department: " +
                departmentName +
                ", employees: " + employees +
                ", serviceCosts: " + serviceCosts;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Department)) {
            return false;
        }

        Department other = (Department) obj;

        if (!Objects.equals(this.departmentName, other.departmentName)) {
            return false;
        }

        if (!Objects.equals(this.employees, other.employees)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName, employees);
    }
}
