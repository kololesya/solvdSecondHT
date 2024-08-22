package entities.vehicle;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class Car extends Vehicle implements Inspectable, Repairable, Paintable, Insurable {
    private static final String CAR_TYPE = "Sedan";
    private String vinNumber;
    private String serviceDate;
    private int manufacturingYear;

    public Car(String producent, String model, String vinNumber, String serviceDate, int manufacturingYear) {
        super(producent, model);
        try {

            this.vinNumber = vinNumber;
            this.serviceDate = String.valueOf(validateAndParseDate(serviceDate));
            this.manufacturingYear = manufacturingYear;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getCarType() {
        return CAR_TYPE;
    }
    public String getVinNumber() {
        return vinNumber;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        validateAndParseDate(serviceDate);
        this.serviceDate = serviceDate;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public static int getCarCount(Car[] cars) {
        return cars.length;
    }

    public int calculateCarAge() {
        int currentYear = Year.now().getValue();
        return currentYear - manufacturingYear;
    }
    @Override
    public void inspect() {
        System.out.println("The car is undergoing technical inspection.");
    }

    @Override
    public void diagnose() {
        System.out.println("Diagnostics of faults is carried out.");
    }

    @Override
    public void repair(boolean isRepairNeeded) {
        if(true){
            System.out.println("The car is being repaired.");
        } else {
            System.out.println("The repair isn't needed");
        }
    }

    @Override
    public void performRepair(String vinNumber, String repairDetails) {
        System.out.println("The " + repairDetails + " on the car " + vinNumber + " has been replaced.");
    }

    @Override
    public void paint(String color) {
        System.out.println("The car is painted in " + color + ".");
    }

    @Override
    public void polish() {
        System.out.println("The car is polished.");
    }

    @Override
    public void insure(String startDate, String endDate) {
        System.out.println("Car insured from " + startDate + " to " + endDate);
    }

    //@Override
    private LocalDate validateAndParseDate(String dateStr) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return LocalDate.parse(dateStr, dateFormatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Please input the date with the pattern yyyy-MM-dd");
        }
    }

    @Override
    public String toString() {
        return super.toString() + CAR_TYPE + ", vinNumber is " + vinNumber + ", service date is " + serviceDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vinNumber, serviceDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        Car other = (Car) obj;
        return vinNumber.equals(other.vinNumber) && serviceDate.equals(other.serviceDate);
    }
}
