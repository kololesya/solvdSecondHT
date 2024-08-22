package entities.people;

public abstract class Employee extends Person implements EmployeeManagement{
    protected double baseSalary;
    private String specialty;

    public Employee(){

    }

    protected Employee(String name, String specialty, double salary) {
        super(name);
        this.specialty = specialty;
        this.baseSalary = salary;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public double getSalary() {
        return baseSalary;
    }

    public void setSalary(double salary) {
        this.baseSalary = salary;
    }

    public abstract void performDuties();

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee by name: " + getName() + " has salary: " + baseSalary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Double.compare(employee.baseSalary, baseSalary) == 0 && getName().equals(employee.getName());
    }

    public void addElement(Employee[] originalArray, Employee employee){
        Employee[] newArray = new Employee[originalArray.length + 1];

        for (int i = 0; i < originalArray.length; i++) {
            newArray[i] = originalArray[i];
        }

        newArray[newArray.length - 1] = employee;
    };

//    @Override
//    public void removeEmployee(String fullName){
//
//    };
}
