package entities.people;

import java.time.LocalDate;

public class Manager extends Employee{
    private double bonus;
    private LocalDate hireDate;

    public Manager(){

    }

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


    public void addElement(Employee[] managers, Manager manager){
        Employee[] newArray = new Employee[managers.length + 1];

        for (int i = 0; i < managers.length; i++) {
            newArray[i] = managers[i];
        }

        newArray[newArray.length - 1] = manager;
    };

    @Override
    public String toString() {
        return super.toString() + ", hire date: " + hireDate;
    }

    @Override
    public void addElement(Employee[] originalArray, Employee employee) {

    }
}
