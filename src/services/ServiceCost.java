package services;

import entities.vehicle.Car;

import java.time.LocalDate;

public abstract class ServiceCost {
    private Car car;
    private String serviceName;
    private LocalDate serviceDate;
    protected double baseCost;

    public ServiceCost(Car car, String serviceName, double baseCost) {
        this.car = car;
        this.serviceName = serviceName;
        this.baseCost = baseCost;
    }

    public abstract double calculateCost();

    @Override
    public String toString() {
        return serviceName + " for the car with " + car.getVinNumber() + " has cost: $" + String.format("%.2f", calculateCost());
    }
}
