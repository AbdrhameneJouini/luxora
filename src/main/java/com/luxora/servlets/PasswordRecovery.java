package com.luxora.servlets;

import com.luxora.beans.Token;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "PasswordRecovery", value = "/PasswordRecovery")
public class PasswordRecovery extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String resetToken = request.getParameter("token");
        String newPassword = request.getParameter("newPassword");


        Token token__ = new Token(resetToken);


        if (token__.checkTokenInDatabase()) {


            System.out.println("the email here is " + token__.getEmail() );
            String purpose = token__.getPurpose();
            String email = token__.getEmail();


            updatePasswordInDatabase(email,newPassword);
            token__.deleteToken();

            System.out.println("Password reset successful for email: " + email + " with purpose: " + purpose);
        } else {

            System.out.println("Invalid or expired reset token.");
        }


    }



    public void updatePasswordInDatabase(String email, String newPassword) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ecommerce", "root", "root")) {
            String query = "UPDATE utilisateur SET mdp = ? WHERE email = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                // Hash the new password before updating the database
                String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
                preparedStatement.setString(1, hashedPassword);
                preparedStatement.setString(2, email);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Password updated successfully for email: " + email);
                } else {
                    System.out.println("Password update failed. User not found with email: " + email);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}