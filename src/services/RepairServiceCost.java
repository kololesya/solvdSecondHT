package services;

import entities.Order.Order;
import entities.vehicle.Car;

import java.time.LocalDate;

public class RepairServiceCost extends ServiceCost {
    private double partsCost;
    private double laborHours;
    private double laborRate;

    public RepairServiceCost(Car car, String serviceName, double baseCost, LocalDate localDate,
                             Order order, double laborHours, double laborRate) {
        super(car, serviceName, baseCost, localDate, order);
        this.partsCost = order.calculateTotalItemsCost();
        this.laborHours = laborHours;
        this.laborRate = laborRate;
    }

    public double getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(double partsCost) {
        this.partsCost = partsCost;
    }

    public double getLaborHours() {
        return laborHours;
    }

    public void setLaborHours(double laborHours) {
        this.laborHours = laborHours;
    }

    public double getLaborRate() {
        return laborRate;
    }

    public void setLaborRate(double laborRate) {
        this.laborRate = laborRate;
    }

    @Override
    public double calculateCost() {
        return baseCost + partsCost + (laborHours * laborRate);
    }
}
