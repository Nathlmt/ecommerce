/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Admin
 */

import java.util.List;
import entity.Product;
public interface ProductDAO {
	// hiển thị danh sách sản phẩm
	public List<Product> getList();
        //hiển thị sản phẩm theo id
	public Product getProduct(int id);
        //hiển thị category theo id
        
}