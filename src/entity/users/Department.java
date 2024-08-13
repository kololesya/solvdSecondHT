package entity.users;

public class Department {
    private Long departmentID;
    private String departmentName;
    private Staff[] staff;
    private Specialist[] specialists;

    public Long getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Long departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(Long departmentID, String departmentName, Staff [] staff) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.staff = staff;
    }

    public Department(Long departmentID, String departmentName, Specialist[] specialists){
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.specialists = specialists;
    }
}
