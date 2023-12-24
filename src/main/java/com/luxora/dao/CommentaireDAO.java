package com.luxora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.luxora.beans.Commentaire;
import com.luxora.beans.Utilisateur;
public class CommentaireDAO {

    public void insertUtilisateur(Utilisateur utilisateur) {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "INSERT INTO utilisateur (nom_uti, prenom_uti, login, mdp, email, address, username, etat) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, utilisateur.getNom_uti());
                preparedStatement.setString(2, utilisateur.getPrenom_uti());
                preparedStatement.setString(4, utilisateur.getMdp());
                preparedStatement.setString(5, utilisateur.getEmail());
                preparedStatement.setString(6, utilisateur.getAddress());
                preparedStatement.setString(7, utilisateur.getUsername());
                preparedStatement.setString(8, utilisateur.getEtat());

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