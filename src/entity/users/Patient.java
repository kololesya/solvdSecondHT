package entity.users;

import java.time.LocalDate;

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

    public Patient(String fullName, String email, Long phoneNumber, int age, char sex) {
        super(fullName, email, phoneNumber);
        this.age = age;
        this.sex = sex;
    }

    public Patient(String fullName, int age) {
        super(fullName);
        this.age = age;
    }

//    public void reserveVisit(PsychologyCenter center, Employee specialist, LocalDate date) {
//        center.bookVisit(this, specialist, date);
//    }

    @Override
    public String toString() {
        return "Patient: " +
                getFullName();
    }
}
