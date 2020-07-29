package com.codeup.adlister.dao;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
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
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    @Override
    public void editUser(Long id, String email, String password) {
        try{
         String query = "UPDATE users SET email = ? ,password = ? WHERE id = ?";
         PreparedStatement stmt = connection.prepareStatement(query);
         stmt.setString(1,email);
         stmt.setString(2,password);
         stmt.setLong(3,id);
         stmt.executeUpdate();
         }catch (SQLException e){
             throw new RuntimeException("Unable to edit user, e");
        }

}

    @Override
    public void deleteUser(Long id) {

    }

//    @Override
//    public User findByID(Long id) {
//        String idQuery = "SELECT * FROM users WHERE id = ?";
//        try{
//            PreparedStatement statement = connection.prepareStatement(idQuery);
//            statement.setLong(1, id);
//            ResultSet rs = statement.executeQuery();
//            if (! rs.next()) {
//                return null;
//            }
//            return extractUser(rs);
//        }catch(SQLException e){
//            throw new RuntimeException("Error finding the ad id", e);
//        }
//    }



    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password")
        );
    }

}
