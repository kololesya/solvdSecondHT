package entity.users;

public class Staff {
    private Long staffID;
    private String firstName;
    private String lastName;
    private String jobTitle;

    public Long getStaffID() {
        return staffID;
    }

    public void setStaffID(Long staffID) {
        this.staffID = staffID;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Staff(Long staffID, String firstName, String lastName, String jobTitle) {
        this.staffID = staffID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
    }
}
