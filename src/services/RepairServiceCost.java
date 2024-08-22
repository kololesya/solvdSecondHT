package services;

import entities.vehicle.Car;
import entities.vehicle.Repairable;

public class RepairServiceCost extends ServiceCost {

    private double partsCost;
    private double laborHours;
    private double laborRate;

    public RepairServiceCost(Car car, String serviceName, double baseCost, double partsCost, double laborHours, double laborRate) {
        super(car, serviceName, baseCost);
        this.partsCost = partsCost;
        this.laborHours = laborHours;
        this.laborRate = laborRate;
    }

    @Override
    public double calculateCost() {
        double laborCost = laborHours * laborRate;
        return baseCost + partsCost + laborCost;
    }
}
