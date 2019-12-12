/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class CustomerDAOImple implements CustomerDAO {

    @Override
    public boolean loginUser(String username, String password) {
        Connection con = DBConnect.getConnect();
        String sql = "SELECT * FROM customer WHERE username='" + username + "' AND password='" + password + "'";
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                con.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Customer getCustomerByUserName(String username) {
        Connection con = DBConnect.getConnect();
        String sql = "SELECT * FROM customer WHERE username='" + username + "'";
        Customer p = new Customer();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int phone = rs.getInt("phone");
                String address = rs.getString("address");
                String city = rs.getString("city_region");
                boolean isAdmin = rs.getBoolean("isAdmin");
                p = new Customer(customer_id, name, email, phone, address, city, username,
                        "password", isAdmin);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
}
