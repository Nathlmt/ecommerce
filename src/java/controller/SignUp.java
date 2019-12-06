package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = {"/sign_up"})
public class SignUp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>GG</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignUp at Vu Minh Tu " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
//          out.println(
//         "<html>\n" +
//         "<head><title>" + "cc" + "</title></head>\n" +
//         "<body bgcolor = \"#f0f0f0\">\n" +
//         "<h1 align = \"center\">" + "cc" + "</h1>\n");
         
        try {
            // Execute SQL query
                         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=eMarket;user=letuan;password=letuan123")) {
                // Execute SQL query
                PreparedStatement st = connection.prepareStatement("insert into customer(name,email,phone,address,username,password"
                        + ") values(?,?, ?, ?, ?, ?)");
                st.setString(1, request.getParameter("name"));
                st.setString(2, request.getParameter("email"));
                st.setString(3, request.getParameter("phone"));
                st.setString(4, request.getParameter("address"));
                st.setString(5, request.getParameter("username"));
                st.setString(6, request.getParameter("password"));
                st.executeUpdate();
                st.close();
            }
        } catch (SQLException | ClassNotFoundException e) {
            out.println("Error when you connect to database!Error is: " + e.getMessage());
        }
//        response.sendRedirect("http://localhost:8080/Project_1"); 
//        out.println("</body></html>");
    
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
