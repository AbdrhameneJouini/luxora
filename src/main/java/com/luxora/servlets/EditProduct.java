package com.luxora.servlets;

import com.luxora.beans.Article;
import com.luxora.beans.DetailArticle;
import com.luxora.dao.ArticleDAO;
import com.luxora.dao.DetailArticleDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@WebServlet(name = "EditProduct", value = "/admin/EditProduct")

public class EditProduct extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reference = request.getParameter("reference");
        DetailArticleDAO detailArticleDAO = new DetailArticleDAO();
        String taille= request.getParameter("taille");

        List<DetailArticle> details = detailArticleDAO.getDetailArticlesByReference(reference);

           int quantite=0;
        request.setAttribute("detailArticles", details);
        for (DetailArticle detail : details) {

            if (detail.getTaille().equals(taille)) {

                 quantite = detail.getQuantite();
                break;

            }
        }
        request.setAttribute("tailleQuantite", quantite);
        request.getRequestDispatcher("products.jsp").forward(request, response);}




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}