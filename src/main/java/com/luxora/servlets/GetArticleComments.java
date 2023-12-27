package com.luxora.servlets;

import com.luxora.beans.Commentaire;
import com.luxora.dao.CommentaireDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetArticleComments", value = "/GetArticleComments")
public class GetArticleComments extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String articleReference = "ProductRef1";
        if (articleReference != null && !articleReference.isEmpty()) {

            CommentaireDAO commentaireDAO = new CommentaireDAO();
            List<Commentaire> comments = commentaireDAO.getCommByReference(articleReference);

            request.setAttribute("articleComments", comments);
        } else {
            request.setAttribute("articleComments", null);
        }


        this.getServletContext().getRequestDispatcher("/commentsSHOW.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST requests if needed
    }
}
