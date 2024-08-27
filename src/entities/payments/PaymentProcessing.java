package entities.payments;

import entities.vehicle.Car;
import services.ServiceCost;

public interface PaymentProcessing {
    void processPayment(Order order);
    void processRefund(Order order);
}
