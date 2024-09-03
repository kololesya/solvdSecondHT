import entities.CarService;
import entities.CarServiceException;
import entities.Logger;
import entities.Order.Order;
import entities.Order.OrderItem;
import entities.payments.PaymentProcessor;
import entities.people.*;
import entities.vehicle.Car;
import services.DiscountedRepairServiceCost;
import services.InspectionServiceCost;

import java.time.LocalDate;
import java.util.*;

import static entities.utils.ServiceUtils.*;

public class Main {
    public static void main(String[] args) throws CarServiceException {
        Logger.info("Starting Car Service application.");

        Set<Employee> employees = new HashSet<>();
        Set<Employee> employees1 = new HashSet<>();
        Set<Department> departments = new HashSet<>();
        CarService carService = new CarService(departments);

        Car car1 = new Car("Toyota", "Corolla", "VIN12345", "2024-08-21", 2015);
        Car car2 = new Car("Honda", "Civic", "VIN54321", "2024-06-21", 2018);
        Car[] cars = {car1, car2};

        System.out.println(calculateCarAge(car2));
        System.out.println(isValidDate(car2.getServiceDate(), "yyyy-MM-dd"));

        Mechanic mechanic1 = new Mechanic("Adam Mickiewicz", 1600, 10, 20, "Engine Specialist", LocalDate.of(2020, 1, 15));
        Mechanic mechanic2 = new Mechanic("Ivan Petrov", 1600, 15, 20, "Engine Specialist", LocalDate.of(2019, 2, 01));
        Manager manager1 = new Manager("John Smith", "manager", 1000, 200, LocalDate.of(2022, 12, 05));
        Manager manager2 = new Manager("Anna Szultz", "manager", 1100, 200, LocalDate.of(2021, 12, 05));
        Mechanic mechanic3 = new Mechanic(null, 0, 0, 0, null, null);

        Department repairAndInspectionDepartment = new Department("Repair and Inspection", employees);
        repairAndInspectionDepartment.addEmployee(mechanic1);
        repairAndInspectionDepartment.addEmployee(mechanic2);
        repairAndInspectionDepartment.addEmployee(manager1);
        repairAndInspectionDepartment.addEmployee(mechanic3);
        repairAndInspectionDepartment.removeEmployee(manager2);

        Department tireDepartment = new Department("Tire department", employees1);
        tireDepartment.addEmployee(mechanic1);
        tireDepartment.addEmployee(manager2);

        carService.addDepartment(repairAndInspectionDepartment);
        carService.addDepartment(tireDepartment);

        carService.removeDepartment(tireDepartment);

        carService.printPayroll();


        InspectionServiceCost inspectionToyota = new InspectionServiceCost(car1, "Whole inspection", 60);
        inspectionToyota.performInspection(car1);
        double x = inspectionToyota.calculateCost();

        InspectionServiceCost inspectionHonda = new InspectionServiceCost(car2, "Engine inspection", 30);
        inspectionToyota.performInspection(car2);
        double y = inspectionHonda.calculateCost();
        System.out.println(x + y);

        DiscountedRepairServiceCost discount = new DiscountedRepairServiceCost(car2, "Engine inspection", inspectionHonda, 15);
        double z = discount.calculateCost();
        System.out.println(z);

        PaymentProcessor paymentProcessor = new PaymentProcessor(discount);
        paymentProcessor.processPayment();

        Customer customer = new Customer("John Doe", 555123478);

        Order order1 = new Order("ORD001", LocalDate.now(), customer, car1);

        OrderItem item1 = new OrderItem("0001", "Oil Change", 150);
        OrderItem item2 = new OrderItem("0002", "Oil Change", 150);
        OrderItem item3 = new OrderItem("0003", "Disk replacement", 300);

        order1.addOrderItem(item1);
        order1.addOrderItem(item2);
        order1.addOrderItem(item3);

        System.out.println(order1.getOrderItems());

        Logger.info("Application finished.");
    }
}