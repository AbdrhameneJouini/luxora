package com.luxora.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luxora.beans.Article;
import com.luxora.dao.ArticleDAO;
import com.luxora.dao.DetailArticleDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

//@WebServlet(name = "GetAllProducts", value = "/admin/GetAllProducts")

@WebServlet(name = "GetAllProducts", value = "/admin/GetAllProducts")
public class GetAllProducts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArticleDAO articleDAO = new ArticleDAO();
        List<Article> articleList = articleDAO.getAllArticles();
        DetailArticleDAO detailArticleDAO = new DetailArticleDAO();
        List<DetailArticle> details = detailArticleDAO.getDetailsByArticleId(articleId);



        request.setAttribute("articleList", articleList);

        this.getServletContext().getRequestDispatcher("/admin/index.jsp?component=products").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST requests if needed
    }
}
