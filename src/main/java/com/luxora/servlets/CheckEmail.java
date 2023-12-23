package com.luxora.servlets;

import com.luxora.dao.UtilisateurDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "CheckEmail", value = "/CheckEmail")
public class CheckEmail extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String email = request.getParameter("email");
        System.out.println("in the check of the email");

        UtilisateurDAO utilisateurDAO  = new UtilisateurDAO();


        boolean emailExists = utilisateurDAO.checkEmailExists(email);


        response.getWriter().write(String.valueOf(emailExists));
    }







}
