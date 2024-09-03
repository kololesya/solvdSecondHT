package services;

import entities.Order.Order;
import entities.vehicle.Car;

import java.time.LocalDate;

public abstract class ServiceCost {
    private Car car;
    private String serviceName;
    private LocalDate serviceDate;
    protected double baseCost;
    private Order order;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ServiceCost(Car car, String serviceName, double baseCost) {
        this.car = car;
        this.serviceName = serviceName;
        this.baseCost = baseCost;
    }

    public ServiceCost(Car car, String serviceName, double baseCost, LocalDate serviceDate) {
        this.car = car;
        this.serviceName = serviceName;
        this.baseCost = baseCost;
        this.serviceDate = serviceDate;
    }

    public ServiceCost(Car car, String serviceName, double baseCost, LocalDate serviceDate, Order order) {
        this.car = car;
        this.serviceName = serviceName;
        this.baseCost = baseCost;
        this.serviceDate = serviceDate;
        this.order = order;
    }

    public abstract double calculateCost();

    @Override
    public String toString() {
        return serviceName + " for the car with " + car.getVinNumber() + " has cost: $" + String.format("%.2f", calculateCost());
    }
}
