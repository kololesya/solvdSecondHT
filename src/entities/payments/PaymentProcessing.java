package entities.payments;

import entities.Order.Order;

public interface PaymentProcessing {
    void processPayment();
    void processRefund();
}
