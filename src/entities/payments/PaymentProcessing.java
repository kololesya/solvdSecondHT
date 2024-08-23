package entities.payments;

import entities.vehicle.Car;
import services.ServiceCost;

public interface PaymentProcessing {
    void processPayment(Car car, ServiceCost[] serviceCosts);

    void processRefund(String orderId, double amount);
}
