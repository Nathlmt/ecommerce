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
    private String thumbImage;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image5;

    public Product() {
    }

    ;
    public Product(int productID, String name, float price,
            String description, String image1,
            String image2, String image3, String image4,
            String image5,String thumbImage,  Date lastUpdate, int categoryID
            ) {
        this.categoryID = categoryID;
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.description = description;
        this.lastUpdate = lastUpdate;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.image5 = image5;
        this.thumbImage = thumbImage;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getDescription() {
        return description;
    }

    public String getImage1() {
        return image1;
    }

    public String getImage2() {
        return image2;
    }

    public String getImage3() {
        return image3;
    }

    public String getImage4() {
        return image4;
    }

    public String getImage5() {
        return image5;
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

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
    public String toStringPrice() {
        return  String.format(("%,.0f" + " đ"), this.price);
    }
}
