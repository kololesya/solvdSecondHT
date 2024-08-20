package entity.users;

public abstract class Employee extends Person {
    private double salary;

    public Employee(String fullName, String email, Long phoneNumber, double salary) {
        super(fullName, email, phoneNumber);
        this.salary = salary;
    }

    public Employee(String fullName) {
        super(fullName);
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void performDuties() {    }
}
