package com.luxora.servlets;

import com.luxora.beans.Client;
import com.luxora.dao.UtilisateurDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");

        Client user = new Client();
        user.setEmail(email);
        user.setMdp(mdp);

        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();


        String loginResult = utilisateurDAO.login(email, mdp);

        System.out.printf("login result is " + loginResult);

        String message;
        String destination;

        switch (loginResult) {
            case "Fatal Error":
                message = "Fatal Error. Please try again.";
                destination = "/login.jsp";
                break;
            case "User not found":
                message = "User not found. Please register.";
                destination = "/register.jsp";
                break;
            case "ACTIVATED":
                message = "User authenticated successfully.";
                destination = "/homepage_old.jsp";
                break;
            case "NOT ACTIVATED":
                message = "Account not activated. Please activate your account.";
                destination = "/SendActivation?email=" + email;
                break;
            case "Suspended":
                message = "Account suspended. Please contact support.";
                destination = "/accountSuspended.jsp";
                break;
            default:
                message = "Unknown error. Please try again.";
                destination = "/login.jsp";
        }

        request.setAttribute("user", user);
        request.setAttribute("message", message);
        this.getServletContext().getRequestDispatcher(destination).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
