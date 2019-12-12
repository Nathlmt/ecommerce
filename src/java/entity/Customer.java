/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class Customer {
    private int customerID;
    private String name;
    private String email;
    private int phoneNumber;
    private String address;
    private String city;
    private String userName;
    private String password;
    private boolean isAdmin;

    public Customer() {
    }

    public Customer(int customerID, String name, String email, int phoneNumber, String address, String city, String userName, String password, boolean isAdmin) {
        this.customerID = customerID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    

    public String getAddress() {
        return address;
    }
    
    public boolean getIsAdmin() {
        return isAdmin;
    }
    
    public String getCity() {
        return city;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
