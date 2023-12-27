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


@WebServlet(name = "DeleteProduct", value = "/admin/DeleteProduct")
public class DeleteProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productIdToDelete="";
        productIdToDelete = request.getParameter("productIdToDelete");
        System.out.println(productIdToDelete);
        System.out.println("hi");

        if (productIdToDelete != null && !productIdToDelete.isEmpty()) {
            ArticleDAO articleDAO = new ArticleDAO();

            articleDAO.deleteDetailArticle(productIdToDelete);
            articleDAO.deleteArticle(productIdToDelete);
            response.getWriter().write("true");


            // Après la suppression, redirigez vers la page souhaitée (peut-être la liste des produits)

        } else {
            // Gestion des erreurs si aucun ID de produit n'est fourni

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Vous pouvez implémenter la logique pour les requêtes POST si nécessaire
        // Par exemple, si vous prévoyez d'ajouter des fonctionnalités de suppression de produits via POST
    }
}