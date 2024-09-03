package entities.payments;

import entities.Logger;
import services.ServiceCost;

public class PaymentProcessor implements PaymentProcessing{
    private ServiceCost serviceCost;

    public PaymentProcessor(ServiceCost serviceCost) {
        this.serviceCost = serviceCost;
    }

    public ServiceCost getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(ServiceCost serviceCost) {
        this.serviceCost = serviceCost;
    }

    @Override
    public void processPayment() {
        if (this.serviceCost == null) {
            Logger.error("Cannot process payment: Service cost is null.");
            return;
        }

        double totalAmount = this.serviceCost.calculateCost();
        String orderId = generateOrderId();

        Logger.info("Processing payment for" + orderId + " | Total Amount: $" + totalAmount);
        Logger.info("Payment of $" + totalAmount + " has been successfully processed for: " + orderId);
    }

    @Override
    public void processRefund() {
        if (this.serviceCost == null) {
            Logger.error("Cannot process refund: Service cost is null.");
            return;
        }

        double totalAmount = this.serviceCost.calculateCost();
        String orderId = generateOrderId();

        Logger.info("Processing refund for Order ID: " + orderId + " | Total Amount: $" + totalAmount);
        Logger.info("Refund of $" + totalAmount + " has been successfully processed for Order ID: " + orderId);
    }

    private String generateOrderId() {
        if (serviceCost == null || serviceCost.getCar() == null || serviceCost.getServiceName() == null) {
            Logger.warn("Unable to generate Order ID: Missing service cost, car, or service name.");
            return "Unknown";
        }

        StringBuilder orderIdBuilder = new StringBuilder();
        orderIdBuilder.append(serviceCost.getServiceName());
        orderIdBuilder.append(" for the car with ");
        orderIdBuilder.append(serviceCost.getCar().getVinNumber());

        return orderIdBuilder.toString();
    }
}
