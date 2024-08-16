package entity.users;

public class Specialist extends Person{
    private int specID;
    private String specialization;

    public int getSpecID() {
        return specID;
    }

    public void setSpecID(int specID) {
        this.specID = specID;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Specialist(int specID, String firstName, String lastName, String specialization) {
        super(firstName, lastName);
        this.specID = specID;
        this.specialization = specialization;
    }

    public Specialist(int specID, String firstName, Long phoneNumber,
                       String fullAddress, String lastName, String specialization) {
        super(firstName, lastName, phoneNumber, fullAddress);
        this.specID = specID;
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Specialist: " +
                firstName +
                " " + lastName;
    }
}