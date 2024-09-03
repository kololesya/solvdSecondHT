package entities;

import entities.people.Department;
import entities.people.Employee;
import entities.vehicle.Car;
import services.ServiceCost;

import java.util.Set;

import static entities.utils.ServiceUtils.addElementToSet;
import static entities.utils.ServiceUtils.removeElementFromSet;

public class CarService implements SalaryCalculable{
    private Set<Department> departments;

    public CarService(Set<Department> departments) {
        this.departments = departments;
    }

    static {
        System.out.println("Welcome to the Car Service System");
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public static double calculateTotalCost(ServiceCost[] serviceCosts) {
        double totalCost = 0;
        for (ServiceCost serviceCost : serviceCosts) {
            totalCost += serviceCost.calculateCost();
        }
        return totalCost;
    }

    public static void printInvoice(ServiceCost[] serviceCosts) {
        for (ServiceCost serviceCost : serviceCosts) {
            System.out.println(serviceCost);
        }
        System.out.println("Total Repair Cost: $" + String.format("%.2f", calculateTotalCost(serviceCosts)));
    }

    @Override
    public double calculateTotalSalary() {
        double totalSalary = 0;
        for (Department department : departments) {
            totalSalary += department.calculateTotalSalary();
        }
        return totalSalary;
    }

    public void printPayroll() {
        for (Department department : departments){
            for(Employee employee : department.getEmployees()){
                System.out.println(employee.getName() + " - " + employee.getSalary());
            }
        }
        System.out.println("Total Salary: $" + String.format("%.2f", calculateTotalSalary()));
    }

    public static void carOnTheService(Car[] cars){
        System.out.println("Total number of cars serviced: " + Car.getCarCount(cars));
    }

    public void removeDepartment(Department department) {
        setDepartments(removeElementFromSet(departments, department));
    }

    public void addDepartment(Department department){
        addElementToSet(departments, department);
    }
}
