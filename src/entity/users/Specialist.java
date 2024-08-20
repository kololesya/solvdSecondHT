package entity.users;

public class Specialist extends Employee{
    private String specialization;

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Specialist(String fullName, String email, Long phoneNumber, double Salary, String specialization) {
        super(fullName, email, phoneNumber, Salary);
        this.specialization = specialization;
    }

    public Specialist(String fullName, String specialization) {
        super(fullName);
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Specialist " + getFullName() + " has specialization "
                + specialization;
    }

    @Override
    public void performDuties() {
        System.out.println("Specialist " + getName() +
                " receives patients");
    }
}