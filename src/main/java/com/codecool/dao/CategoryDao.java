package com.codecool.dao;

import com.codecool.models.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao extends Dao {

    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        connect();

        try {
            ResultSet results = statement.executeQuery("SELECT * FROM Category;");
            while (results.next()) {
                int ID = results.getInt("Category ID");
                String category = results.getString("Category");
                Category newCategory = new Category(ID, category);
                categories.add(newCategory);
            }
            results.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    public void createCategory(String category) {
        connect();

        try {

            statement.executeUpdate("INSERT INTO Category (Category)" +
                    String.format("VALUES ('%s')", category));
            statement.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}