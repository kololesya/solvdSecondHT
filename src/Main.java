import entities.payments.PaymentProcessor;
import entities.people.Employee;
import entities.people.Mechanic;
import entities.people.Manager;
import entities.utils.ServiceUtils;
import entities.vehicle.Car;
import services.InspectionServiceCost;
import services.RepairServiceCost;
import services.ServiceCost;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarServiceMain carServiceMain = new CarServiceMain();

        Car car1 = new Car("Toyota", "Corolla", "VIN12345", "2024-08-21", 2015);
        Car car2 = new Car("Honda", "Civic", "VIN54321", "2024-06-21", 2018);
        Car[] cars = {car1, car2};

        System.out.println(ServiceUtils.calculateCarAge(car2.getManufacturingYear()));
        System.out.println(ServiceUtils.isValidDate(car2.getServiceDate(), "yyyy-MM-dd"));
        System.out.println(car2.getCarType());

        Employee employee = new Manager();

        Mechanic mechanic1 = new Mechanic("Adam Mickiewicz", 1600, 10, 20, "Engine Specialist", LocalDate.of(2020, 1, 15));
        Mechanic mechanic2 = new Mechanic("Ivan Petrov", 1600, 15, 20, "Engine Specialist", LocalDate.of(2019, 2, 01));
        Manager manager1 = new Manager("John Smith", "manager", 1000, 200, LocalDate.of(2022, 12, 05));
        Manager manager2 = new Manager("Anna Szultz", "manager", 1100, 200, LocalDate.of(2021, 12, 05));

        Employee[] employees = new Employee[0];
        employees = employee.addElement(employees,manager1);
        employees = employee.addElement(employees, manager2);
        employees = employee.addElement(employees, mechanic1);
        employees = employee.addElement(employees, mechanic2);

        CarServiceMain.printArrayEmployees(employees);
        carServiceMain.printPayroll(employees);

        System.out.println(carServiceMain.calculateTotalSalary(employees));
        InspectionServiceCost inspectionToyota = new InspectionServiceCost(car1, "Whole inspection", 60);
        inspectionToyota.performInspection(car1);
        double x = inspectionToyota.calculateCost();

        InspectionServiceCost inspectionHonda = new InspectionServiceCost(car2, "Engine inspection", 30);
        inspectionToyota.performInspection(car2);
        double y = inspectionHonda.calculateCost();
        System.out.println(x + " " + y);

        ServiceCost[] serviceCosts = {inspectionToyota, inspectionHonda};
        System.out.println(CarServiceMain.calculateTotalCost(serviceCosts));
        CarServiceMain.printInvoice(serviceCosts);

        System.out.println("Оплата для заказа " + car1.getVinNumber() + " на сумму $ " + inspectionHonda.calculateCost() + " успешно обработана.");

        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processPayment(car1, serviceCosts);
    }
}