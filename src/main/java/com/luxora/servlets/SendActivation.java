package com.luxora.servlets;

import com.luxora.beans.EmailSender;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SendActivation", value = "/SendActivation")
public class SendActivation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        System.out.println("\n email is "+email);

        EmailSender emailSender = new EmailSender();

        String token = emailSender.sendVerificationEmail(email);




        this.getServletContext().getRequestDispatcher("/accountNotActivated.jsp?token=" + token).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}