import entities.people.Employee;
import entities.vehicle.Car;
import services.ServiceCost;

public class CarServiceMain {
    private Employee[] employees;
    private ServiceCost[] serviceCosts;

    static {
        System.out.println("Welcome to the Car Service System");
    }

    public double calculateTotalCost(ServiceCost[] serviceCosts) {
        double totalCost = 0;
        for (ServiceCost serviceCost : serviceCosts) {
            totalCost += serviceCost.calculateCost();
        }
        return totalCost;
    }

    public void printInvoice(ServiceCost[] serviceCosts) {
        for (ServiceCost serviceCost : serviceCosts) {
            System.out.println(serviceCost);
        }
        System.out.println("Total Repair Cost: $" + String.format("%.2f", calculateTotalCost(serviceCosts)));
    }

    public double calculateTotalSalary(Employee[] employees) {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.calculateSalary();
        }
        return totalSalary;
    }

    public void printPayroll(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("Total Salary: $" + String.format("%.2f", calculateTotalSalary(employees)));
    }

    public static void carOnTheService(Car[] cars){
        System.out.println("Total number of cars serviced: " + Car.getCarCount(cars));
    }

}
