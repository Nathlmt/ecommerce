package dao;

import dao.ProductDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;
import java.util.Date;

public class ProductDAOImple implements ProductDAO {

    @Override
    public List<Product> getList() {
        Connection con = DBConnect.getConnect();
        String sql = "SELECT * FROM product;";
        List<Product> list = new ArrayList<Product>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM product;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt("product_id");
                int categoryID = rs.getInt("Categorycategory_id");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                String description = rs.getString("description");
                String descriptionDetail = rs.getString("description_detail");
                String image = rs.getString("image");
                String thumbImage = rs.getString("thumb_image");
                Date lastUpdate = rs.getDate("last_update");
                list.add(new Product(productID, name, price, description, lastUpdate, categoryID, image, thumbImage, descriptionDetail));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

//    public Product getProduct(int id) {
//        Connection con = DBConnect.getConnect();
//        String sql = "SELECT * FROM PRODUCT WHERE ma_san_pham='" + id + "'";
//        Product p = new Product();
//        try {
//            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//            
//                int gia_ban = rs.getInt("gia_ban");
//                p = new Product(ma_san_pham, ma_loai_san_pham, ten_san_pham, hinh_anh_1, hinh_anh_2, hinh_anh_3, hinh_anh_4, hinh_anh_5, gia_ban);
//            }
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return p;
////    }
    public static void main(String[] args) {
        //Product p = new Product(0, 1, "S6", "da", 500000.0 ,"","");
        ProductDAOImple productDAO = new ProductDAOImple();
        System.out.println(productDAO.getList().get(0));
        System.out.println("hello");
        Product p = new Product();
        System.out.println(p);
    }
}
