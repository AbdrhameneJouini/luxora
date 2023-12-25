package com.luxora.dao;

import com.luxora.beans.DetailArticle;

import java.sql.*;

public class DetailArticleDAO {



    public void insertDetailArticle(DetailArticle detailArticle) {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "INSERT INTO detailArticle (reference, taille, quantite) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

                preparedStatement.setString(1, detailArticle.getReference());
                preparedStatement.setString(2, detailArticle.getTaille());
                preparedStatement.setInt(3, detailArticle.getQuantite());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("DetailArticle added");

                } else {
                    System.out.println("No DetailArticle added.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
