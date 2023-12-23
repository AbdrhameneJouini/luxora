package com.luxora.beans;

import java.sql.*;

public class Token {
    private String token;
    private String email;
    private String purpose;

    public Token() {

    }
    public Token(String token) {
        this.token = token;
    }

    public Token(String token, String email, String purpose) {
        this.token = token;
        this.email = email;
        this.purpose = purpose;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {

        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    public void insertToken() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ecommerce", "root", "root")) {
            // Delete existing tokens with the same purpose and email
            deleteExistingTokens(connection);

            // Insert the new token
            String insertQuery = "INSERT INTO tokens (token, purpose, email, expiration_datetime) VALUES (?, ?, ?, DATE_ADD(NOW(), INTERVAL 2 HOUR))";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                insertStatement.setString(1, token);
                insertStatement.setString(2, purpose);
                insertStatement.setString(3, email);

                int rowsAffected = insertStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Token inserted successfully.");
                } else {
                    System.out.println("Token insertion failed.");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteExistingTokens(Connection connection) throws SQLException {
        String deleteQuery = "DELETE FROM tokens WHERE purpose = ? AND email = ?";
        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
            deleteStatement.setString(1, purpose);
            deleteStatement.setString(2, email);

            int rowsAffected = deleteStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Existing tokens deleted successfully.");
            } else {
                System.out.println("No existing tokens found.");
            }
        }
    }



    public boolean checkTokenInDatabase() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ecommerce", "root", "root")) {
            String query = "SELECT purpose, email FROM tokens WHERE token = ? AND expiration_datetime > NOW()";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, token);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        purpose = resultSet.getString("purpose");
                        email = resultSet.getString("email");
                        System.out.println("The token is found and email is "+ email + " and purpose is " + purpose);

                        return true;
                    }
                    else {
                        return false;
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean deleteToken() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ecommerce", "root", "root")) {
            String query = "DELETE FROM tokens WHERE token = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, token);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Token deleted successfully.");
                    return true;
                } else {
                    System.out.println("Token deletion failed. Token not found.");
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
