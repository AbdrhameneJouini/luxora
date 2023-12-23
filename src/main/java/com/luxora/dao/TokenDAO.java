package com.luxora.dao;


import com.luxora.beans.Token;
import com.luxora.dao.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TokenDAO {

    public void insertToken(Token token) {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "INSERT INTO tokens (token, purpose, email) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, token.getToken());
                preparedStatement.setString(2, token.getPurpose());
                preparedStatement.setString(3, token.getEmail());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Token inserted successfully.");
                } else {
                    System.out.println("Token insertion failed.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkTokenInDatabase(String tokenValue) {
        try (Connection connection = DBConnection.getConnection()) {
            String query = "SELECT purpose, email FROM tokens WHERE token = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, tokenValue);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String purpose = resultSet.getString("purpose");
                        String email = resultSet.getString("email");
                        System.out.println("The token is found. Email: " + email + ", Purpose: " + purpose);
                        return true;
                    } else {
                        System.out.println("Token not found in the database.");
                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
