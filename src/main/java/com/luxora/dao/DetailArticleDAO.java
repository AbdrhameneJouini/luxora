package com.luxora.dao;

import com.luxora.beans.Article;
import com.luxora.beans.DetailArticle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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


    public void updateArticle(DetailArticle article) {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "UPDATE detailarticle SET quantite = ? WHERE reference = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, article.getReference());
                preparedStatement.setInt(2, article.getQuantite());


                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Article updated successfully.");
                } else {
                    System.out.println("Article update failed. Article not found.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<DetailArticle> getDetailArticlesByReference(String reference) {
        List<DetailArticle> details = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT * FROM detailarticle WHERE reference = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, reference);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {

                        DetailArticle detailArticle = new DetailArticle();
                        detailArticle.setReference(resultSet.getString("reference"));
                        detailArticle.setTaille(resultSet.getString("taille"));
                        detailArticle.setQuantite(resultSet.getInt("quantite"));


                        details.add(detailArticle);
                    }
                }
            }
        } catch (SQLException e) {

        }
        return details;
    }
    public Integer getQuantityByReferenceAndSize(String reference, String taille) {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT quantite FROM detailarticle WHERE reference = ? AND taille = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, reference);
                preparedStatement.setString(2, taille);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getInt("quantite");
                    } else {
                        System.out.println("Article not found.");
                        return null;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    }





