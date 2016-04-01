package Classes;

public class Supplier {
 
    private int supplierID;
    private String supplierName, address1, address2, city, postcode, phoneNo, email;

    public Supplier(int supplierID, String supplierName, String address1, String address2, String city, String postcode, String phoneNo, String email) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.postcode = postcode;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public Supplier(String supplierName, String address1, String address2, String city, String postcode, String phoneNo, String email) {
        this.supplierName = supplierName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.postcode = postcode;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public int getSupplierID() {
        return supplierID;
    }
    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }
    public String getSupplierName() {
        return supplierName;
    }
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
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
}