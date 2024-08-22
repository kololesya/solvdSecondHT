package services;

import entities.vehicle.Car;

public class DiscountedRepairServiceCost extends RepairServiceCost {
    private double discountPercentage;

    public DiscountedRepairServiceCost(Car car, String serviceName, double baseCost, double partsCost, double laborHours, double laborRate, double discountPercentage) {
        super(car, serviceName, baseCost, partsCost, laborHours, laborRate);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculateCost() {
        double originalCost = super.calculateCost();
        double discountAmount = originalCost * (discountPercentage / 100);
        return originalCost - discountAmount;
    }
}
