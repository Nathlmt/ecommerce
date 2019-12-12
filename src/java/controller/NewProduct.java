/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Product;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Admin
 */
public class NewProduct extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String applicationPath = getServletContext().getRealPath("");
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("descriptiom");
        Part[] part = new Part[5];
        part[0] = request.getPart("image1");
        part[1] = request.getPart("image2");
        part[2] = request.getPart("image3");
        part[3] = request.getPart("image4");
        part[4] = request.getPart("image5");

        String[] filename = new String[5];
        filename[0] = part[0].getSubmittedFileName();
        filename[1] = part[1].getSubmittedFileName();
        filename[2] = part[2].getSubmittedFileName();
        filename[3] = part[3].getSubmittedFileName();
        filename[4] = part[4].getSubmittedFileName();

        Product p;
        p = new Product(, ten_san_pham, fileName, filename[1], filename[2], filename[3], filename[4], gia_tien);
        ProductDAOImple productDAO = new ProductDAOImple();
        productDAO.addProduct(p);
        response.sendRedirect("addproductadmin.jsp");
    }
}
