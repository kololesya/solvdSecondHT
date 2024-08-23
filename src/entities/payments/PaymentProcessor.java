package entities.payments;

import entities.vehicle.Car;
import services.InspectionServiceCost;
import services.RepairServiceCost;
import services.ServiceCost;

public class PaymentProcessor implements PaymentProcessing{
    private Car car;
    private InspectionServiceCost inspectionServiceCost;
    private RepairServiceCost repairServiceCost;
    ;
//    @Override
//    public void processPayment(Car car, ServiceCost[] serviceCosts) {
//        for (int i = 0; i < serviceCosts.length; i++) {
//            if(serviceCosts[i].equals(inspectionServiceCost)){
//                System.out.println("Оплата для заказа " + car.getVinNumber() + " на сумму $ " + inspectionServiceCost.calculateCost() + " успешно обработана.");
//            } else if ()
//        }
//
//
//    }
    @Override
    public void processRefund(String orderId, double amount) {


        System.out.println("Возврат средств для заказа " + orderId + " на сумму $ " + amount + " успешно выполнен.");
    }
}
