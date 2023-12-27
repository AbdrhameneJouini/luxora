package com.luxora.servlets;

import com.luxora.beans.Commentaire;
import com.luxora.dao.CommentaireDAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Addcomm")
public class Addcom extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String texteCommentaire = request.getParameter("comm");

        Commentaire nouveauCommentaire = new Commentaire();
        nouveauCommentaire.setTexte(texteCommentaire);


        CommentaireDAO commentaireDAO = new CommentaireDAO();
        commentaireDAO.insertComm(nouveauCommentaire);


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>Commentaire ajouté avec succès!</h1></body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}
    	