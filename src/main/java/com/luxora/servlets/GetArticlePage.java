package com.luxora.servlets;

import com.luxora.beans.Article;
import com.luxora.dao.ArticleDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetArticleDetails", value = "/GetArticleDetails")
public class GetArticlePage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String articleId = request.getParameter("articleId"); // Get the article ID from the form

        System.out.println("id is " + articleId);

        ArticleDAO infoProduit = new ArticleDAO();
        Article article = infoProduit.getArticleById(articleId);
        System.out.println(article.getNom_Article());


        if (article != null) {
            request.setAttribute("article", article);
            request.getRequestDispatcher("DetaileArticle.jsp").forward(request, response); // Redirect to your_page.jsp
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}