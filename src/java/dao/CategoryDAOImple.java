/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Category;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CategoryDAOImple implements  CategoryDAO{
    
       public Category getCategoryByID(int id) {
        Connection con = DBConnect.getConnect();
        String sql = "SELECT * FROM category WHERE category_id='" + id + "'";
        Category c = new Category();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int categoryID = rs.getInt("category_id");
                String categoryName = rs.getString("name");
              c = new Category(categoryID,categoryName);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
           public List<Category> getListCategorys() {
        Connection con = DBConnect.getConnect();
        String sql = "SELECT * FROM category;";
        List<Category> list = new ArrayList<Category>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM category;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int categoryID = rs.getInt("category_id");
                String name = rs.getString("name");
                list.add(new Category(categoryID, name));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}

