package Classes;

public class Staff {

    private int staffID, manager;
    private String firstName, surname, phoneNo, email, password, salt;

    public Staff(int staffID, String firstName, String surname, String phoneNo, String email, String password, int manager, String salt) {
        this.staffID = staffID;
        this.manager = manager;
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNo = phoneNo;
        this.email = email;
        this.password = password;
        this.salt = salt;
    }
    
        public Staff(String firstName, String surname, String phoneNo, String email, String password, int manager, String salt) {
        this.manager = manager;
        this.firstName = firstName;
        this.surname = surname;
        this.phoneNo = phoneNo;
        this.email = email;
        this.password = password;
        this.salt = salt;
    }

    public int getStaffID() {
        return staffID;
    }
    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }
    public int getManager() {
        return manager;
    }
    public void setManager(int manager) {
        this.manager = manager;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }    
}
