/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Order {
    private int orderID;
    private double amount;
    private Date dateCreated;
    private int confirmationNumber;
    private int customerID;
    private ProductList productList;
    public double getAmount() {
        return amount;
    }

    public int getConfirmationNumber() {
        return confirmationNumber;
    }

    public int getCustomerID() {
        return customerID;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setConfirmationNumber(int confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public ProductList getProductList() {
        return productList;
    }

    public void setProductList(ProductList productList) {
        this.productList = productList;
    }
  
}
