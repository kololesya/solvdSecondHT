package entity.users;

abstract class Person {
    private String fullName;
    private String email;
    private Long phoneNumber;

    public Person(String name, String email, Long phoneNumber) {
        this.fullName = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Person(String fullName) {
        this.fullName = fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhoneNumber(){
        return phoneNumber;
    }
}
