package entities.people;

import java.time.LocalDate;

public class Mechanic extends Employee{
    private double overtimeHours;
    private double overtimeRate;
    private LocalDate hireDate;

    public Mechanic(String name, double baseSalary, double overtimeHours, double overtimeRate, String specialty, LocalDate hireDate) {
        super(name, specialty, baseSalary);
        this.overtimeHours = overtimeHours;
        this.overtimeRate = overtimeRate;
        this.hireDate = hireDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " is performing mechanical duties.");
    }

    @Override
    public double calculateSalary() {
        double overtimePay = overtimeHours * overtimeRate;
        return baseSalary + overtimePay;
    }

    @Override
    public String toString() {
        return super.toString() + ", specialty: " + getSpecialty() + ", hire date: " + hireDate;
    }
}
