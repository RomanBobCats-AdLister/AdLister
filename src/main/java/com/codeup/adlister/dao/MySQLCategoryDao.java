package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.codeup.adlister.models.Category;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
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
    public List<Categories> all() {
        return null;
    }

    @Override
    public User findByUsername(String username) {
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
