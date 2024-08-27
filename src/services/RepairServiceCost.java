package services;

import entities.vehicle.Car;

public class RepairServiceCost extends ServiceCost {

    private double partsCost;
    private double laborHours;
    private double laborRate;

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
