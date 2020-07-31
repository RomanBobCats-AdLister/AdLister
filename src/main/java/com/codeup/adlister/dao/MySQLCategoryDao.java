package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.codeup.adlister.models.Category;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoryDao implements Categories {
    private Connection connection;

    public MySQLCategoryDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public Category findByCategory(String categoryName) {
        String query = "SELECT * FROM categories WHERE category = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, categoryName);
            return extractCategory(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a category", e);
        }
    }

    public List<Category> searchCategory(String query) {
        PreparedStatement stmt = null;
        String sqlQuery = ("SELECT * FROM categories WHERE category LIKE ?");
        String categorySearch = "%" + query + "%";

        try {
            stmt = connection.prepareStatement(sqlQuery);
            stmt.setString(1, categorySearch);

            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            return createCategoryFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving from query", e);
        }
    }

    private List<Category> createCategoryFromResults(ResultSet rs) throws SQLException {
        List<Category> category = new ArrayList<>();
        while (rs.next()) {
            category.add(extractCategory(rs));
        }
        return category;
    }

    public Category findById(long id) {
//        String idQuery = "SELECT * FROM categories WHERE id = ?";
        try{
            Statement statement = connection.createStatement();
//            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery("SELECT * FROM categories WHERE id = " + id);
            if (! rs.next()) {
                return null;
            }
            return extractCategory(rs);

        }catch(SQLException e){
            throw new RuntimeException("Error finding the category id", e);
        }
    }

    private Category extractCategory(ResultSet rs) throws SQLException {
        return new Category(
                rs.getLong("id"),
                rs.getString("category"));
    }

    @Override
    public List<Categories> all() {
        return null;
    }


    @Override
    public Long insert(Category category) {
        String query = "INSERT INTO categories(id, category) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, category.getId());
            stmt.setString(2, category.getCategory());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new category", e);
        }
    }

}
