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


@WebServlet(name = "AddProduct", value = "/admin/AddProduct")
public class AddProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reference = request.getParameter("productReference");
        String productName = request.getParameter("productName");
        String productPrice = request.getParameter("productPrice");
        String productDescription = request.getParameter("productDescription");
        String productCategory = request.getParameter("productCategory");

        // Create Article object and insert it into the Article table
        Article article = new Article(reference, productName, Double.parseDouble(productPrice), productCategory, productDescription);
        ArticleDAO articleDAO = new ArticleDAO();
        articleDAO.insertArticle(article);

        // Create arrays to store sizes and quantities
        List<String> sizesArray = new ArrayList<>();
        List<String> quantitiesArray = new ArrayList<>();

        for (String size : Arrays.asList("XS", "S", "M", "L", "XL", "XXL")) {
            String sizeParam = request.getParameter("size_" + size);
            String quantityParam = request.getParameter("quantity_" + size);

            // Check if both sizeParam and quantityParam are not null
            if (sizeParam != null && quantityParam != null) {
                // Use sizeParam and quantityParam as needed
                System.out.println("Size: " + sizeParam + ", Quantity: " + quantityParam);

                // Add non-null sizes and quantities to arrays
                sizesArray.add(sizeParam);
                quantitiesArray.add(quantityParam);

                // Create DetailArticle object and insert it into the DetailArticle table
                DetailArticle detailArticle = new DetailArticle(reference, sizeParam, Integer.parseInt(quantityParam));
                DetailArticleDAO detailArticleDAO = new DetailArticleDAO();
                detailArticleDAO.insertDetailArticle(detailArticle);
            }
        }

        // Now you have sizesArray and quantitiesArray containing the non-null sizes and quantities
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
