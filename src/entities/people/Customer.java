package entities.people;

public class Customer extends Person{

    private long phoneNumber;
    public Customer(String name) {
        super(name);
    }

    public Customer(String name, long phoneNumber){
        super(name);
        this.phoneNumber = phoneNumber;
    }
}
