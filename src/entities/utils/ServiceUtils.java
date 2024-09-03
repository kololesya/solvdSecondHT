package entities.utils;

import entities.CarServiceException;
import entities.SalaryCalculable;
import entities.Order.Order;
import entities.Order.OrderItem;
import entities.people.Department;
import entities.people.Employee;
import entities.vehicle.Car;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import static entities.Logger.error;
import static entities.Logger.info;
import static entities.Order.Order.isValidOrder;

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
        info("Calculated age for car with VIN " + car.getVinNumber() + " is " + age + " years");
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
            info("Most expensive item in Order ID: " + order.getOrderId() + " is " +
                    mostExpensiveItem.getName() + " with price $" + mostExpensiveItem.getPrice());
        }
        return mostExpensiveItem;
    }

    public static <T> Set<T> addElementToSet(Set<T> set, T element) {
        try {
            if (element == null) {
                throw new CarServiceException("Cannot add a null element to the set.");
            }

            if (element instanceof Employee) {
                Employee employee = (Employee) element;
                if (!isValidEmployee(employee)) {
                    throw new CarServiceException("Cannot add an employee with invalid data: " + employee);
                }
            }

            if (element instanceof Department) {
                Department department = (Department) element;
                if (!isValidDepartment(department)) {
                    throw new CarServiceException("Cannot add a department with invalid data: " + department);
                }
            }

            set.add(element);

        } catch (CarServiceException e) {
            error("Error adding element: " + e.getMessage());
        } finally {
            info("Attempted to add a new element.");
        }
        return set;
    }

    public static <T> List<T> addElementToList(List<T> list, T element) {
        try {
            if (element == null) {
                throw new CarServiceException("Cannot add a null element to the list.");
            }

            if (element instanceof Order) {
                Order order = (Order) element;
                if (!isValidOrder(order)) {
                    throw new CarServiceException("Cannot add an order with invalid data: " + order);
                }
            }
//
//            if (list.contains(element)) {
//                throw new CarServiceException("Cannot add duplicate element: " + element);
//            }

            list.add(element);

        } catch (CarServiceException e) {
            error("Error adding element: " + e.getMessage());
        } finally {
            info("Attempted to add a new element.");
        }
        return list;
    }

    public static <T> Set<T> removeElementFromSet(Set<T> set, T element) {
        Set<T> newSet = new HashSet<>();

        try {
            if (set == null) {
                throw new NullPointerException("The set cannot be null.");
            }

            if (element == null) {
                throw new IllegalArgumentException("The element to remove cannot be null.");
            }

            if (element instanceof Employee) {
                Employee employee = (Employee) element;
                if (!isValidEmployee(employee)) {
                    throw new CarServiceException("Cannot remove an employee with invalid data: " + employee);
                }
            }

            if (element instanceof Department) {
                Department department = (Department) element;
                if (!isValidDepartment(department)) {
                    throw new CarServiceException("Cannot remove a department with invalid data: " + department);
                }
            }

            newSet.addAll(set);

            if (!newSet.remove(element)) {
                throw new IllegalArgumentException("The element to remove is not found in the set.");
            }

        } catch (NullPointerException | IllegalArgumentException | CarServiceException e) {
            error("Error: " + e.getMessage());
            return set;
        } finally {
            info("Attempted to remove an element.");
        }

        return newSet;
    }


    public static void printTotalSalary(SalaryCalculable entity) {
        System.out.println("Total Salary: " + entity.calculateTotalSalary());
    }

    public static boolean isValidEmployee(Employee employee) {
        return employee.getName() != null && !employee.getName().trim().isEmpty()
                && employee.getSalary() > 0;
    }

    private static boolean isValidDepartment(Department department) {
        return department.getDepartmentName() != null && !department.getDepartmentName().trim().isEmpty()
                && department.getEmployees() != null && !department.getEmployees().isEmpty();
    }


}
