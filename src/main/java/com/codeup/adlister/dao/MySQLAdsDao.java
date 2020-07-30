package com.codeup.adlister.dao;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
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
    public List<Ad> adsByUser(long id) {
        PreparedStatement stmt = null;
        try {
            String insertQuery = "SELECT * FROM ads WHERE user_id = ?";
            stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving your ads.", e);
        }
    }

    @Override
    public List<Ad> search(String query) {
        PreparedStatement stmt = null;
        String sqlQuery = ("SELECT * FROM ads WHERE title LIKE ?");
        String userInput = "%" + query + "%";

        try {
            stmt = connection.prepareStatement(sqlQuery);
            stmt.setString(1, userInput);

            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving from query", e);
        }
    }
    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(title, user_id, description, cat_id) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, ad.getTitle());
            stmt.setLong(2, ad.getUserId());
            stmt.setString(3, ad.getDescription());
            stmt.setLong(4, ad.getCategory().getId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public Ad findById(long id) {
        String idQuery = "SELECT * FROM ads WHERE id = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(idQuery);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (! rs.next()) {
                return null;
            }
            return extractAd(rs);

        }catch(SQLException e){
            throw new RuntimeException("Error finding the ad id", e);
        }
    }

    @Override
    public Ad editAdTitle(long id, String title) {
        findById(id);
        String editAdQuery = "UPDATE ads SET title = ? WHERE id = ? ";
        try{
            PreparedStatement statement = connection.prepareStatement(editAdQuery);
            statement.setString(1, title);
            statement.setLong(2, id);
            statement.executeUpdate();
            return null;
        }catch(SQLException e){
            throw new RuntimeException("Error updating the ad title", e);
        }
    }
    @Override
    public Ad editAdDescription(long id, String description) {
        findById(id);
        String editAdQuery = "UPDATE ads SET description = ? WHERE id = ? ";
        try{
            PreparedStatement statement = connection.prepareStatement(editAdQuery);
            statement.setString(1, description);
            statement.setLong(2, id);
            statement.executeUpdate();
            return null;
        }catch(SQLException e){
            throw new RuntimeException("Error updating the ad description", e);
        }
    }


    @Override
    public Ad deleteAd(long id){
        findById(id);
        String deleteAdQuery = "DELETE FROM ads WHERE id = ?";
        try{
            PreparedStatement statement = connection.prepareStatement(deleteAdQuery);
            statement.setLong(1, id);
            boolean confirmDeletion = statement.execute();
            return null;
        }catch(SQLException e){
            throw new RuntimeException("Error. Unable to delete ad.", e);
        }
    }

    // may need to modify this to get the category from add
    private Ad extractAd(ResultSet rs) throws SQLException {

        return new Ad(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description"),
                new Category(
                        1,
                        "test"
                )

        );
    }


    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
}
