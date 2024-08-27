package entities.utils;

import entities.Logger;
import entities.payments.Order;
import entities.payments.OrderItem;
import entities.people.Employee;
import entities.vehicle.Car;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ServiceUtils {
    public static boolean isValidDate(String dateStr, String format) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(format);
        try {
            LocalDate.parse(dateStr, dateFormatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static int calculateCarAge(Car car) {
        int currentYear = LocalDate.now().getYear();
        int manufacturingYear = car.getManufacturingYear();
        int age = currentYear - manufacturingYear;
        Logger.info("Calculated age for car with VIN " + car.getVinNumber() + " is " + age + " years");
        return age;
    }

    public static LocalDate validateAndParseDate(String dateStr) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return LocalDate.parse(dateStr, dateFormatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Please input the date with the pattern yyyy-MM-dd");
        }
    }

    public static int findEmployeeIndexByName(Employee[] employees, String name) {
        try {
            if (employees == null) {
                throw new NullPointerException("The employee array is null.");
            }

            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("The name cannot be null or empty.");
            }

            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null && employees[i].getName().equals(name)) {
                    return i;
                }
            }

            return -1;
        } catch (NullPointerException e) {
            System.err.println("Error: " + e.getMessage());
            return -1;
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            return -1;
        }
    }

//    public static <T extends Vehicle> void vehicleSummary(T vehicle) {
//        System.out.println("Vehicle Summary: " + vehicle.toString());
//    }

    public static OrderItem findMostExpensiveItem(Order order) {
        OrderItem mostExpensiveItem = null;
        double highestPrice = 0.0;
        for (OrderItem item : order.getOrderItems()) {
            if (item != null && item.getPrice() > highestPrice) {
                mostExpensiveItem = item;
                highestPrice = item.getPrice();
            }
        }
        if (mostExpensiveItem != null) {
            Logger.info("Most expensive item in Order ID: " + order.getOrderId() + " is " +
                    mostExpensiveItem.getName() + " with price $" + mostExpensiveItem.getPrice());
        }
        return mostExpensiveItem;
    }
}
