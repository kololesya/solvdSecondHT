package entities;

import entities.people.Department;
import entities.people.Employee;
import entities.service.Service;
import entities.vehicle.Car;
import services.ServiceCost;

public class CarService {

    private Service[] services;
    private ServiceCost[] serviceCosts;

    private Department[] departments;

    public ServiceCost[] getServiceCosts() {
        return serviceCosts;
    }

    public void setServiceCosts(ServiceCost[] serviceCosts) {
        this.serviceCosts = serviceCosts;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    static {
        System.out.println("Welcome to the Car Service System");
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

    //@Override
    public double calculateTotalSalary() {
        double totalSalary = 0;
        for (Department department : departments) {
            totalSalary += department.calculateTotalSalary();
        }
        return totalSalary;
    }

//    public void printPayroll(Employee[] employees) {
//        for (Employee employee : employees) {
//            System.out.println(employee.getName() + " - " + employee.getSalary());
//        }
//        System.out.println("Total Salary: $" + String.format("%.2f", calculateTotalSalary(employees)));
//    }

    public static void printArrayEmployees(Employee[] employees){
        for(Employee employee : employees){
            System.out.println(employee.toString());
        }
    }

    public static void carOnTheService(Car[] cars){
        System.out.println("Total number of cars serviced: " + Car.getCarCount(cars));
    }

    public Department[] addDepartmentToService(Department[] originalArray, Department department) {
        Department[] newArray;
        try {
            if (originalArray == null) {
                throw new NullPointerException("The department array cannot be null.");
            }

            if (department == null) {
                throw new IllegalArgumentException("The new department cannot be null.");
            }

            newArray = new Department[originalArray.length + 1];

            for (int i = 0; i < originalArray.length; i++) {
                newArray[i] = originalArray[i];
            }

            newArray[originalArray.length] = department;

        } catch (NullPointerException e) {
            System.err.println("Error: " + e.getMessage());
            newArray = originalArray;
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            newArray = originalArray;
        } finally {
            System.out.println("Attempted to add a new department.");
        }

        return newArray;
    }

}
