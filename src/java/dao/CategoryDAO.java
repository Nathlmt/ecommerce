/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Category;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CategoryDAO {
      public Category getCategoryByID(int id);
      public List<Category> getListCategorys();
}
