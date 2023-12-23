package com.luxora.servlets;

import com.luxora.beans.Client;
import com.luxora.beans.Token;
import com.luxora.dao.UtilisateurDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ActivateAccount", value = "/ActivateAccount")
public class ActivateAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String token = request.getParameter("token");
        System.out.println("IN ACTIVATE ACCOUNT NICE with token " +  token);

        Token token__ = new Token(token);
        if (token__.checkTokenInDatabase())
        {

            String email = token__.getEmail();
            token__.deleteToken();


            UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
            utilisateurDAO.activateAccount(email);
            this.getServletContext().getRequestDispatcher("/accountActivated.jsp" ).forward(request, response);
        }else {

            this.getServletContext().getRequestDispatcher("/linkExpired.jsp" ).forward(request, response);
        };


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}