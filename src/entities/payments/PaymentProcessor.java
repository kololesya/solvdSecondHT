package entities.payments;

import entities.Logger;

public class PaymentProcessor implements PaymentProcessing{

    private double calculateTotalAmount(Order order) {
        double totalAmount = 0.0;
        for (OrderItem item : order.getOrderItems()) {
            if (item != null) {
                totalAmount += item.getPrice();
            }
        }
        return totalAmount;
    }
    public void processPayment(Order order){
        if (order == null) {
            Logger.error("Cannot process payment: order is null.");
            return;
        }

        double totalAmount = calculateTotalAmount(order);
        Logger.info("Processing payment for Order ID: " + order.getOrderId() + " | Total Amount: $" + totalAmount);

        Logger.info("Payment of $" + totalAmount + " has been successfully processed for Order ID: " + order.getOrderId());

    }
    public void processRefund(Order order){
        if (order == null) {
            Logger.error("Cannot process refund: order is null.");
            return;
        }

        double totalAmount = calculateTotalAmount(order);
        Logger.info("Processing refund for Order ID: " + order.getOrderId() + " | Total Amount: $" + totalAmount);

        Logger.info("Refund of $" + totalAmount + " has been successfully processed for Order ID: " + order.getOrderId());
    }


}
