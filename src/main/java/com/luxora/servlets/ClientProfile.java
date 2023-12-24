package com.luxora.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.luxora.beans.Client;

import com.luxora.dao.ClientDAO;

@WebServlet("/Profile")
public class ClientProfile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        int Idclt = Integer.parseInt(request.getParameter("Idclt")); // Get the article ID from the form
       
        System.out.println(Idclt);
        
        ClientDAO infoclt = new ClientDAO();
        Client clt = infoclt.getClientById(Idclt );
        System.out.println(clt.getNom_uti());
        
        
        if (clt != null) {
            request.setAttribute("clt", clt);
            request.getRequestDispatcher("Profile.jsp").forward(request, response); // Redirect to your_page.jsp
        } 
    }}