package entity.users;

public class Staff extends Person{
    private Long staffID;
    private String jobTitle;

    public Long getStaffID() {
        return staffID;
    }

    public void setStaffID(Long staffID) {
        this.staffID = staffID;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Staff(Long staffID, String firstName, String lastName, String jobTitle) {
        super(firstName, lastName);
        this.staffID = staffID;
        this.jobTitle = jobTitle;
    }

    public Staff(Long staffID, String firstName, String lastName, Long phoneNumber,
                 String fullAddress, String jobTitle) {
        super(firstName, lastName, phoneNumber, fullAddress);
        this.staffID = staffID;
        this.jobTitle = jobTitle;
    }
}
