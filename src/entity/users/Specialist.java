package entity.users;

public class Specialist {
    private int specID;
    private String firstName;
    private String lastName;
    private String specialization;

    public int getSpecID() {
        return specID;
    }

    public void setSpecID(int specID) {
        this.specID = specID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Specialist(int specID, String firstName, String lastName, String specialization) {
        this.specID = specID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Specialist: " +
                firstName +
                " " + lastName;
    }
}