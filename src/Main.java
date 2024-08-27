import entities.CarService;
import entities.Logger;
import entities.payments.Order;
import entities.payments.OrderItem;
import entities.people.*;
import entities.vehicle.Car;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Logger.info("Starting application...");

        CarService carService = new CarService();

        Car car1 = new Car("Toyota", "Corolla", "VIN12345", "2024-08-21", 2015);
        Car car2 = new Car("Honda", "Civic", "VIN54321", "2024-06-21", 2018);
        Car[] cars = {car1, car2};
//
//        System.out.println(ServiceUtils.calculateCarAge(car2.getManufacturingYear()));
//        System.out.println(ServiceUtils.isValidDate(car2.getServiceDate(), "yyyy-MM-dd"));
//        System.out.println(car2.getCarType());

        Mechanic mechanic1 = new Mechanic("Adam Mickiewicz", 1600, 10, 20, "Engine Specialist", LocalDate.of(2020, 1, 15));
        Mechanic mechanic2 = new Mechanic("Ivan Petrov", 1600, 15, 20, "Engine Specialist", LocalDate.of(2019, 2, 01));
        Manager manager1 = new Manager("John Smith", "manager", 1000, 200, LocalDate.of(2022, 12, 05));
        Manager manager2 = new Manager("Anna Szultz", "manager", 1100, 200, LocalDate.of(2021, 12, 05));

        Employee[] employees = new Employee[0];
        Department departmentRepairAndInspection = new Department("Repair and Inspection");
        employees = departmentRepairAndInspection.addEmployeeToDepartment(employees, mechanic1);
        employees = departmentRepairAndInspection.addEmployeeToDepartment(employees, mechanic2);

        departmentRepairAndInspection.setEmployees(employees);

        Employee[] employees1 = new Employee[0];
        Department departmentManagement = new Department("Management");
        employees1 = departmentManagement.addEmployeeToDepartment(employees1, manager1);
        employees1 = departmentManagement.addEmployeeToDepartment(employees1, manager2);

        departmentManagement.setEmployees(employees1);

        System.out.println(Arrays.toString(departmentRepairAndInspection.getEmployees()));
        System.out.println(Arrays.toString(departmentManagement.getEmployees()));
//
//        System.out.println(Arrays.toString(departmentRepairAndInspection.removeEmployee(employees, "Ivan Petrov")));

//        CarServiceMain.printArrayEmployees(employees);
//        carServiceMain.printPayroll(employees);
//
//        System.out.println(carServiceMain.calculateTotalSalary(employees));
//        InspectionServiceCost inspectionToyota = new InspectionServiceCost(car1, "Whole inspection", 60);
//        inspectionToyota.performInspection(car1);
//        double x = inspectionToyota.calculateCost();
//
//        InspectionServiceCost inspectionHonda = new InspectionServiceCost(car2, "Engine inspection", 30);
//        inspectionToyota.performInspection(car2);
//        double y = inspectionHonda.calculateCost();
//        System.out.println(x + " " + y);
//
//        ServiceCost[] serviceCosts = {inspectionToyota, inspectionHonda};
//        System.out.println(CarServiceMain.calculateTotalCost(serviceCosts));
//        CarServiceMain.printInvoice(serviceCosts);
//
//        System.out.println("Оплата для заказа " + car1.getVinNumber() + " на сумму $ " + inspectionHonda.calculateCost() + " успешно обработана.");
//
//        PaymentProcessor paymentProcessor = new PaymentProcessor();
//        paymentProcessor.processPayment(car1, serviceCosts);

        Customer customer = new Customer("John Doe", 555123478);

        Order order1 = new Order("ORD001", LocalDate.now(), customer, car1, 2);

        OrderItem item1 = new OrderItem("0001", "a", 150);
        OrderItem item2 = new OrderItem("0002", "b", 200);
        OrderItem item3 = new OrderItem("0003", "c", 300);

        order1.addOrderItem(item1);
        order1.addOrderItem(item2);
        order1.addOrderItem(item3);

        for (OrderItem item : order1.getOrderItems()) {
            if (item != null) {
                Logger.info("Item: " + item.getName() + ", price: $" + item.getPrice());
            }
        }

        System.out.println(order1.calculateTotalExpenses());
        System.out.println(departmentRepairAndInspection.calculateTotalSalary());

        Department[] departments = new Department[0];

        carService.addDepartmentToService(departments, departmentRepairAndInspection);
        //carService.addDepartmentToService(departments, departmentManagement);
        carService.setDepartments(departments);

        System.out.println(Arrays.toString(carService.getDepartments()));



        Logger.info("Application finished.");
    }
}