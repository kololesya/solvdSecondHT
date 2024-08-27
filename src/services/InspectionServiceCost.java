package services;

import entities.vehicle.Car;

public class InspectionServiceCost extends ServiceCost {
    private int ageOfCar;

    public InspectionServiceCost(Car car, String serviceName, double baseCost) {
        super(car, serviceName, baseCost);
        this.ageOfCar = car.calculateCarAge();
    }

    @Override
    public double calculateCost() {
        if (ageOfCar <= 5){
            return baseCost;
        } else if(ageOfCar > 5 && ageOfCar <=10){
            return baseCost * 0.1 + baseCost;
        } else {
            return baseCost * 0.2 + baseCost;
        }
    }

    public void performInspection(Car car) {
        car.inspect();
        car.diagnose();
        System.out.println("Inspection Service for " + car.getProducent() +
                " " + car.getModel() + " " + car.getVinNumber() + " is completed. The cost is: " + calculateCost());
    }
}
