package entities.payments;

public interface PaymentProcessing {
    void processPayment(Order order);
    void processRefund(Order order);
}
