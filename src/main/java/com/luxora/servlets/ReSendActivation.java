package com.luxora.servlets;

import com.luxora.beans.EmailSender;
import com.luxora.beans.Token;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReSendActivation", value = "/ReSendActivation")
public class ReSendActivation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        String token = request.getParameter("token");
        System.out.println("\n token is "+token);
        Token token__ = new Token(token);


        if (token__.checkTokenInDatabase()) {


            System.out.println("the email here is " + token__.getEmail() );
            String purpose = token__.getPurpose();
            String email = token__.getEmail();
            EmailSender emailSender = new EmailSender();
            emailSender.sendVerificationEmail(email);

            System.out.println("Verification email sent : " + email + " with purpose: " + purpose);
        } else {

            System.out.println("Invalid or expired reset token.");
        }




        this.getServletContext().getRequestDispatcher("/accountNotActivated.jsp?token=" + token).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}