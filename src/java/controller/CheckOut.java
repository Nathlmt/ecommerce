/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class CheckOut extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            // Execute SQL query
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String name = request.getParameter("name");
            System.out.println("controller.CheckOut.doPost()" + name);
            try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=eMarket;user=letuan;password=letuan123")) {
                // Execute SQL query 
                HttpSession session = request.getSession();
                int customerID = (int) session.getAttribute("customer");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDateTime now = LocalDateTime.now();
                PreparedStatement st = connection.prepareStatement("insert into customer_order(name, confirmation_number, date_created, customer_id, address"
                        + ") values(?,?, ?, ?, ?)");
                st.setString(1, request.getParameter("name"));
                st.setString(2, request.getParameter("phone"));
                st.setString(3, now.toString());
                st.setInt(4, customerID);
                st.setString(5, request.getParameter("address"));
                st.executeUpdate();
                st.close();
                response.sendRedirect("/Project_1/index.jsp");
            } catch (NullPointerException e) {
                response.sendRedirect("/Project_1/index.jsp");
            }
        } catch (SQLException | ClassNotFoundException e) {
            out.println("Error when you connect to database!Error is: " + e.getMessage());
            response.sendRedirect("/Project_1/index.jsp");

        }
//        response.sendRedirect("http://localhost:8080/Project_1"); 
//        out.println("</body></html>");

    }
}
