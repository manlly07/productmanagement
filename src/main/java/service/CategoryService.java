package service;

import com.sun.xml.bind.v2.model.core.ID;
import entity.Category;
import util.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private static CategoryService INSTANCE;

    private CategoryService() {

    }

    public static CategoryService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CategoryService();
        }
        return INSTANCE;
    }

    public List<Category> getCategory() {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from categories");
            ResultSet rs = statement.executeQuery();
            List<Category> categories = new ArrayList<>();
            while (rs.next()) {
                Category category = new Category();
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                category.setId(id);
                category.setName(name);
                category.setDescription(description);
                categories.add(category);
            }
            rs.close();
            statement.close();
            return categories;
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }finally {
            Database.close(connection);
        }
    }
    public boolean deleteCategory(String id) {
        Connection connection = Database.getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM `categories` WHERE id = ?");
            statement.setString(1, id);
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected > 0) {
                return true;
            }else {
                throw new RuntimeException("Can not delete this category");
            }
        }catch (Exception error) {
            throw new RuntimeException(error.getMessage());
        }
    }
}
