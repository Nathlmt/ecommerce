/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class CustomerDAOImple implements CustomerDAO{
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
}
