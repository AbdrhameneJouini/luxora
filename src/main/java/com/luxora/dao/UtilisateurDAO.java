package com.luxora.dao;

import com.luxora.beans.Article;
import com.luxora.beans.Client;
import com.luxora.beans.Utilisateur;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class UtilisateurDAO {

    public void insertUtilisateur(Utilisateur utilisateur) {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "INSERT INTO utilisateur (nom_uti, prenom_uti, login, mdp, email, address, username, etat) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, utilisateur.getNom_uti());

                preparedStatement.setString(2, utilisateur.getPrenom_uti());

               

                preparedStatement.setString(4, utilisateur.getMdp());
                preparedStatement.setString(5, utilisateur.getEmail());
                preparedStatement.setString(7, utilisateur.getUsername());


                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Utilisateur inserted successfully.");
                } else {
                    System.out.println("Utilisateur insertion failed.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean checkEmailExists(String email) {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ecommerce","root","root")) {
            String query = "SELECT 1 FROM utilisateur WHERE email = ? ";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, email);


                try (ResultSet resultSet = preparedStatement.executeQuery()) {

                    if (resultSet.next()) {

                        System.out.println("Email is used ");
                        return true;
                    } else {
                        System.out.println("Email is unique");
                        return false;
                    }
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void signUp( String firstName, String lastName, String userName,String email ,String hashedPassword, String gender, String address) {
        Connection connection = null;

        // SQL statements
        String insertUtilisateurQuery = "INSERT INTO Utilisateur (nom_uti, prenom_uti, username, mdp, gender, email) VALUES (?, ?, ?, ?, ?, ?)";
        String insertClientQuery = "INSERT INTO Client (id_uti, address) VALUES (?, ?)";

        try {
            // Establish the database connection
            connection = DBConnection.getConnection();

            // Start a transaction
            connection.setAutoCommit(false);

            // Insert into Utilisateur
            try (PreparedStatement utilisateurStatement = connection.prepareStatement(insertUtilisateurQuery, Statement.RETURN_GENERATED_KEYS)) {
                utilisateurStatement.setString(1, lastName);
                utilisateurStatement.setString(2, firstName);
                utilisateurStatement.setString(3, userName);
                utilisateurStatement.setString(4, hashedPassword);
                utilisateurStatement.setString(5, gender);
                utilisateurStatement.setString(6, email);

                // Execute the Utilisateur query
                utilisateurStatement.executeUpdate();

                // Retrieve the generated id_uti
                ResultSet generatedKeys = utilisateurStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int lastInsertedId = generatedKeys.getInt(1);

                    // Insert into Client with the last inserted id_uti
                    try (PreparedStatement clientStatement = connection.prepareStatement(insertClientQuery)) {
                        clientStatement.setInt(1, lastInsertedId);
                        clientStatement.setString(2, address);

                        // Execute the Client query
                        clientStatement.executeUpdate();
                    }
                }
            }

            // Commit the transaction if everything is successful
            connection.commit();

        } catch (SQLException e) {
            // Rollback the transaction if there's an exception
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            // Close the database connection and set auto-commit back to true
            try {
                if (connection != null) {
                    connection.setAutoCommit(true);
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public String login(String email, String enteredPassword) {
        System.out.println("\n in login : email " + email + " mdp : " + enteredPassword + " \n");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ecommerce", "root", "root")) {
            String query = "SELECT u.id_uti, c.etat, u.mdp FROM utilisateur u JOIN client c ON u.id_uti = c.id_uti WHERE u.email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, email);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Retrieve hashed password and etat from the database
                        String hashedPassword = resultSet.getString("mdp");
                        int userId = resultSet.getInt("id_uti");
                        String etat = resultSet.getString("etat");

                        // Check if the entered password matches the hashed password
                        if (BCrypt.checkpw(enteredPassword, hashedPassword)) {
                            // If the passwords match, login is successful
                            System.out.printf("Login successful. User ID: %d, Etat: %s\n", userId, etat);
                            return etat;
                        } else {
                            // If passwords don't match, login fails
                            System.out.println("Invalid login credentials");
                            return "Invalid login credentials";
                        }
                    } else {
                        // No user found with the given email
                        System.out.println("User not found");
                        return "User not found";
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately in a real-world scenario
            return "Fatal Error";
        }
    }


    public boolean activateAccount(String email) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ecommerce", "root", "root")) {
            String updateQuery = "UPDATE client SET etat = 'ACTIVATED' WHERE id_uti IN (SELECT id_uti FROM utilisateur WHERE email = ?)";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                updateStatement.setString(1, email);

                int rowsAffected = updateStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Account activated successfully.");
                    return true;
                } else {
                    System.out.println("Account activation failed. User not found.");
                    return false;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateEmail(String oldMail,String newEmail) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ecommerce", "root", "root")) {
            String updateQuery = "UPDATE utilisateur SET email = ? WHERE email = ?";
            try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                updateStatement.setString(1, newEmail);
                updateStatement.setString(2, oldMail);

                int rowsAffected = updateStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Email updated successfully.");

                    return true;
                } else {
                    System.out.println("Email update failed. User not found.");
                    return false;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


   

}
