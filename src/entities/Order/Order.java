package entities.Order;

import entities.Logger;
import entities.people.Customer;
import entities.vehicle.Vehicle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static entities.utils.ServiceUtils.addElementToList;

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

    public void addOrderItem(OrderItem item){
        addElementToList(orderItems, item);
    }

    public double calculateTotalItemsCost() {
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public static boolean isValidOrder(Order order) {

        return order.getOrderId() != null && !order.getOrderId().trim().isEmpty()
                && order.getOrderDate() != null && order.getCustomer() != null
                && order.getVehicle() != null;
    }

    @Override
    public String toString() {
        return "OrderId " + orderId +
                ", customer: " + customer +
                ", orderDate: " + orderDate +
                ", orderItems: " + orderItems +
                ", vehicle: " + vehicle;
    }
}
