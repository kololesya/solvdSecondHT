package entity.users;

public class Patient extends Person{
    private int age;
    private char sex;

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

    public Patient(String firstName, String lastName, int age, char sex) {
        super(firstName, lastName);
        this.age = age;
        this.sex = sex;
    }

    public Patient(String firstName, String lastName, Long phoneNumber, String fullAddress, int age, char sex) {
        super(firstName, lastName, phoneNumber, fullAddress);
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
