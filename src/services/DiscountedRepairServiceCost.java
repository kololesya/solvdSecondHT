package services;

import entities.vehicle.Car;

public class DiscountedRepairServiceCost extends ServiceCost {
    private double discountPercentage;
    private ServiceCost originalServiceCost;

    public DiscountedRepairServiceCost(Car car, String serviceName, ServiceCost originalServiceCost, double discountPercentage) {
        super(car, serviceName, originalServiceCost.calculateCost());
        this.discountPercentage = discountPercentage;
        this.originalServiceCost = originalServiceCost;
    }

    @Override
    public double calculateCost() {
        double originalCost = originalServiceCost.calculateCost();
        double discountAmount = originalCost * (discountPercentage / 100);
        return originalCost - discountAmount;
    }
}
