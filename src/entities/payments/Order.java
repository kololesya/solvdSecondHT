package entities.payments;

import entities.Logger;
import entities.people.Customer;
import entities.vehicle.Vehicle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Order {
    private String orderId;
    private Customer customer;
    private LocalDate orderDate;
    private List<OrderItem> orderItems;
    private static double totalExpenses;
    private Vehicle vehicle;

    public Order(String orderId, LocalDate orderDate, Customer customer, Vehicle vehicle) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customer = customer;
        this.vehicle = vehicle;
        this.orderItems = new ArrayList<>();
        Logger.info("Order created with ID: " + orderId);
    }

//    public void addOrderItem(OrderItem item) {
//        try {
//            if (item == null) {
//                throw new IllegalArgumentException("Order item cannot be null.");
//            }
//            if (itemCount >= orderItems.length) {
//                throw new ArrayIndexOutOfBoundsException("It's impossible to add more items; the order is full.");
//            }
//            orderItems[itemCount] = item;
//            itemCount++;
//            Logger.info("Added item to order: " + item.getName());
//        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
//            Logger.error("Error adding order item: " + e.getMessage());
//        }
//    }

    public double calculateTotalExpenses() {
        double total = 0;
        for (OrderItem item : orderItems) {
            total += item.getPrice();
        }
        return total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
