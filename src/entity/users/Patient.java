package entity.users;

public class Patient {
    private Long patientID;
    private String firstName;
    private String lastName;
    private int age;
    private char sex;

    public Long getPatientID() {
        return patientID;
    }

    public void setPatientID(Long patientID) {
        this.patientID = patientID;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Patient(Long patientID, String firstName, String lastName, int age, char sex) {
        this.patientID = patientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Patient: " +
                firstName +
                " " + lastName +
                ", age: " + age;
    }
}
