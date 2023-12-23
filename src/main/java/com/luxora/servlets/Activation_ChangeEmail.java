package com.luxora.servlets;

import com.luxora.beans.Client;
import com.luxora.beans.EmailSender;
import com.luxora.beans.Token;
import com.luxora.dao.UtilisateurDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Activation_ChangeEmail", value = "/Activation_ChangeEmail")
public class Activation_ChangeEmail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String token = request.getParameter("token");
            String newEmail = request.getParameter("newEmail");
            System.out.println("token" + token + " and email are "+ newEmail);
            Token token__ = new Token(token);

            if(token__.checkTokenInDatabase()){
                String oldMail = token__.getEmail();
                token__.deleteToken();



                UtilisateurDAO utilisateurDAO = new UtilisateurDAO();


                utilisateurDAO.updateEmail(oldMail,newEmail);

                EmailSender emailSender = new EmailSender();


                String new_token = emailSender.sendVerificationEmail(newEmail);

                this.getServletContext().getRequestDispatcher("/accountNotActivated.jsp?token=" + new_token).forward(request, response);


            }else{
                System.out.println("Token not valid");
            };


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}