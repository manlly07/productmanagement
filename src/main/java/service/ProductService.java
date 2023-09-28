package service;

import entity.Category;
import entity.Product;
import util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private static ProductService INSTANCE;

    private ProductService() {

    }

    public static ProductService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ProductService();
        }
        return INSTANCE;
    }

    public List<Product> getCategory(String find) {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from products join categories on products.category_id = categories.id where categories.id = ?");
            statement.setString(1, find);
            ResultSet rs = statement.executeQuery();
            List<Product> products = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                Long id = rs.getLong("id");
                Long cateId = rs.getLong("category_id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int price = rs.getInt("price");
                product.setId(id);
                product.setName(name);
                product.setDescription(description);
                product.setPrice(price);
                products.add(product);
            }
            rs.close();
            statement.close();
            return products;
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }finally {
            Database.close(connection);
        }
    }

    public Product getProductById(String find) {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from products join categories on products.category_id = categories.id where products.id = ?");
            statement.setString(1, find);
            ResultSet rs = statement.executeQuery();
            Product product = new Product();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int price = rs.getInt("price");
                product.setId(id);
                product.setName(name);
                product.setDescription(description);
                product.setPrice(price);
            }
            rs.close();
            statement.close();
            return product;
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }finally {
            Database.close(connection);
        }
    }

    public boolean updateProduct(String cateId, String idPr) {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("update products set category_id = ? where id = ?");
            statement.setString(1, cateId);
            statement.setString(2, idPr);
            int count = statement.executeUpdate();
            if(count > 0) {
                statement.close();
                return true;
            }
            return false;
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }finally {
            Database.close(connection);
        }
    }
}
