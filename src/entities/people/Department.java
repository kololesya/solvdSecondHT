package entities.people;

import static entities.utils.ServiceUtils.findEmployeeIndexByName;

public class Department implements EmployeeManagement{
    private String departmentName;
    private Employee[] employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(String departmentName, Employee[] employees) {
        this.departmentName = departmentName;
        this.employees = employees;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    @Override
    public Employee[] addEmployeeToDepartment(Employee[] originalArray, Employee employee) {
        Employee[] newArray;
        try {
            if (originalArray == null) {
                throw new NullPointerException("The employee array cannot be null.");
            }

            if (employee == null) {
                throw new IllegalArgumentException("The new employee cannot be null.");
            }

            newArray = new Employee[originalArray.length + 1];

            for (int i = 0; i < originalArray.length; i++) {
                newArray[i] = originalArray[i];
            }

            newArray[originalArray.length] = employee;

        } catch (NullPointerException e) {
            System.err.println("Error: " + e.getMessage());
            newArray = originalArray;
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            newArray = originalArray;
        } finally {
            System.out.println("Attempted to add a new employee.");
        }

        return newArray;
    }

    @Override
    public Employee[] removeEmployee(Employee[] employees, String fullName) {
        try {
            if (employees == null) {
                throw new NullPointerException("Employee array is empty");
            }

            if (fullName == null || fullName.trim().isEmpty()) {
                throw new IllegalArgumentException("Full name cannot be empty. Please input a name and surname");
            }

            int index = findEmployeeIndexByName(employees, fullName);

            if (index < 0 || index >= employees.length) {
                throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
            }

            Employee[] newArray = new Employee[employees.length - 1];

            for (int i = 0, j = 0; i < employees.length; i++) {
                if (i != index) {
                    newArray[j++] = employees[i];
                }
            }

            return newArray;
        }  catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: " + e.getMessage());
            return employees;
        } catch (NullPointerException e) {
            System.err.println("Error: " + e.getMessage());
            return employees;
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            return employees;
        }
    }

    @Override
    public double calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.calculateSalary();
        }
        return totalSalary;
    }

}
