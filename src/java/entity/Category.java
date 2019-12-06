package entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Category {
    private int categoryID;
    private String name;
    public Category(){};
    public Category(int id, String name) {
        this.categoryID = id;
        this.name = name;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
    
}
