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
public class Product {

    private int productID;
    private String name;
    private float price;
    private String description;
    private Date lastUpdate;
    private int categoryID;
    private String image;
    private String thumbImage;
    private String descriptionDetail;
    
    public Product() {};
    public Product(int productID, String name, float price, String description, Date lastUpdate, int categoryID, String image, String thumbImage,String descriptionDetail ) {
        this.categoryID = categoryID;
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.description = description;
        this.lastUpdate = lastUpdate;
        this.image = image;
        this.thumbImage = thumbImage;
        this.descriptionDetail = descriptionDetail;
    }
    public int getCategoryID() {
        return categoryID;
    }

    public String getDescription() {
        return description;
    }

    public String getDescriptionDetail() {
        return descriptionDetail;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public float getPrice() {
        return price;
    }

    public int getProductID() {
        return productID;
    }

    public String getThumbImage() {
        return thumbImage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setThumbImage(String thumbImage) {
        this.thumbImage = thumbImage;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescriptionDetail(String descriptionDetail) {
        this.descriptionDetail = descriptionDetail;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public String toString() {
        return this.name; //To change body of generated methods, choose Tools | Templates.
    
    }
    
    
}
