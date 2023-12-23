package com.luxora.servlets;

import com.luxora.dao.UtilisateurDAO;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
@WebServlet(name = "Signup", value = "/Signup")
public class Signup extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        String hashedPassword = hashPassword(password);


        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        utilisateurDAO.signUp(firstName,lastName,userName,email,hashedPassword,gender,address);



        this.getServletContext().getRequestDispatcher("/SendActivation?email=" + email).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public static String hashPassword(String password) {

        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}