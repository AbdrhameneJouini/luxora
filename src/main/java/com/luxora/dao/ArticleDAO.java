
package com.luxora.dao;

import com.luxora.beans.Article;
import com.luxora.dao.DBConnection;
import com.luxora.dao.VueDAO;
import com.luxora.beans.Vue;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {


    private void prepareStatements(Article article, PreparedStatement preparedStatement) throws SQLException {

        preparedStatement.setString(1, article.getReference());
        preparedStatement.setDouble(2, article.getPrix());
        preparedStatement.setString(3, article.getNom_Article());
        preparedStatement.setString(4, article.getCategorie());
        preparedStatement.setString(5, article.getDescription());
        preparedStatement.setString(6, article.getImage());

    }
    public void insertArticle(Article article) {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "INSERT INTO articles (reference ,Prix, Nom_Article, category ,Description, Image) VALUES (? ,?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                prepareStatements(article, preparedStatement);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Article inserted successfully.");


                } else {
                    System.out.println("Article insertion failed.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void updateArticle(Article article) {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "UPDATE article SET Prix=?, Nom_Article=?, Description=?, Image=? WHERE Reference=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                prepareStatements(article, preparedStatement);
                // NEEDS AN UPDATE
                preparedStatement.setString(7, article.getReference());

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

    public void deleteArticle(String reference) {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "DELETE FROM article WHERE Reference=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, reference);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Article deleted successfully.");

                } else {
                    System.out.println("Article deletion failed. Article not found.");
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception while deleting article: " + e.getMessage());
            e.printStackTrace(); // Ceci affichera les détails de l'exception dans la console pour le débogage
            throw new RuntimeException(e);

        }
    }
    public void deleteDetailArticle(String reference) {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "DELETE FROM detailarticle WHERE reference=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, reference);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Article deleted successfully.");
                } else {
                    System.out.println("Article deletion failed. Article not found.");
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception while deleting article: " + e.getMessage());
            e.printStackTrace(); // Ceci affichera les détails de l'exception dans la console pour le débogage
            throw new RuntimeException(e);

        }
    }

    public Article getArticleById( String articleId) {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT * FROM article WHERE Reference=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, articleId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int nbVues = resultSet.getInt("nbvues");
                        nbVues++;

                        return mapResultSetToArticle(resultSet);
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
    public Article rechercherArticleParNom(String nom) {
        try (Connection connection = DBConnection.getConnection()) {
            Article article = null;
            String query = "SELECT * FROM produits WHERE nom = ?";


            try   (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, nom);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return mapResultSetToArticle(resultSet);
                }
                else {
                    System.out.println("Article not found.");
                    return null;
                }
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    public List<Article> getAllArticles() {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT * FROM article";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    List<Article> articles = new ArrayList<>();
                    while (resultSet.next()) {
                        articles.add(mapResultSetToArticle(resultSet));
                    }
                    return articles;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Article mapResultSetToArticle(ResultSet resultSet) throws SQLException {
        Article article = new Article();
        article.setReference(resultSet.getString("Reference"));
        article.setPrix(resultSet.getInt("Prix"));
        article.setNom_Article(resultSet.getString("Nom_Article"));
        article.setDescription(resultSet.getString("Description"));
        article.setImage(resultSet.getString("Image"));
        article.setCategorie(resultSet.getString("categorie"));


        return article;
    }



    public static void main(String[] args) {
        ArticleDAO infoProduit = new ArticleDAO();
        String articleId = "1"; // Remplacez par l'ID de l'article que vous souhaitez récupérer

        Article article = infoProduit.getArticleById(articleId);

        if (article != null) {
            System.out.println("Article trouvé : " + article.getNom_Article());
            // Affichez d'autres détails de l'article si nécessaire
        } else {
            System.out.println("Aucun article trouvé avec l'ID : " + articleId);
        }
    }
}
