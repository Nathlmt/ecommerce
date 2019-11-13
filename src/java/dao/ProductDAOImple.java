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
                String image1 = rs.getString("image1");
                String image2 = rs.getString("image2");
                String image3 = rs.getString("image3");
                String image4 = rs.getString("image4");
                String image5 = rs.getString("image5");
                String description = rs.getString("description");
                String thumbImage = rs.getString("thumb_image");
                Date lastUpdate = rs.getDate("last_update");
                list.add(new Product(productID, name, price, description, image1, image2, image3, image4, image5, thumbImage, lastUpdate, categoryID));
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
        ProductDAOImple productDAO1 = new ProductDAOImple();
        productDAO1.getList().forEach((p) -> {
            System.out.print(p.getImage1());
        });
    }
}
