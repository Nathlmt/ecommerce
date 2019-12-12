/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Admin
 */
public class ults {

    public static String convertPrice(double price) {
         return  String.format(("%,.0f"), price) + " đ";
    }
}
