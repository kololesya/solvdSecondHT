package entity.users;

public class Admin extends Employee{

    public Admin(String fullName, String email, Long phoneNumber, double salary) {
        super(fullName, email, phoneNumber, salary);
    }

    public Admin(String fullName) {
        super(fullName);
    }

    @Override
    public void performDuties() {
        System.out.println("Admin " + getFullName() +
                " manages appointment bookings.");
    }
}
