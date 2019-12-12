/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Product;
import dao.ProductDAOImple;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

/**
 *
 * @author Admin
 */
public class addToCart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //To change body of generated methods, choose Tools | Templates.
        HttpSession session = req.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
        }

        String productID = req.getParameter("productid");
        String quantity = req.getParameter("quantity");

        if (!productID.isEmpty()) {
            ProductDAOImple producdaoImple = new ProductDAOImple();
            Product product = producdaoImple.getProduct(Integer.parseInt(productID));
            cart.addItem(product, quantity);
//                        session.setAttribute("cart", cart);
            resp.sendRedirect("/Project_1/cart.jsp");

        }
    }

}
