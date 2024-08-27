package entities.people;

import java.time.LocalDate;

public class Manager extends Employee{
    private double bonus;
    private LocalDate hireDate;

    public Manager(String name, String specialty, double baseSalary, double bonus, LocalDate hireDate) {
        super(name, specialty, baseSalary);
        this.bonus = bonus;
        this.hireDate = hireDate;
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " is performing manager duties.");
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }

    @Override
    public String toString() {
        return super.toString() + ", hire date: " + hireDate;
    }
}
