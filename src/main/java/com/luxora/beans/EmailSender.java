package com.luxora.beans;

import org.apache.commons.lang3.RandomStringUtils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
    final private String email = "ecommerce.smtp.polytech@gmail.com";
    final private String app_password = "gprn etpm ikqi jzul";

    private Token  token__;
    public EmailSender() {

        token__ = new Token();
    }

    public String sendVerificationEmail(String toEmail) {
        token__.setToken(generateRandomCode());
        token__.setPurpose("Verification");
        token__.setEmail(toEmail);
        token__.insertToken();
        sendEmail(toEmail, "Account Verification", "Dear User,\n\nPlease click the following link to verify and activate your account:\n\n"
                + "http://localhost:8080/Project_war_exploded/ActivateAccount?token=" + token__.getToken());

        return token__.getToken();
    }

    public void sendPasswordResetEmail(String toEmail) {
        token__.setToken(generateRandomCode());
        token__.setPurpose("Recovery");
        token__.setEmail(toEmail);
        token__.insertToken();
        sendEmail(toEmail, "Password Reset", "Dear User,\n\nPlease click the following link to reset your password:\n\n"
                + "http://localhost:8080/Project_war_exploded/passwordRecovery.jsp?token=" + token__.getToken());
    }

    private void sendEmail(String toEmail, String subject, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); // replace with your email server host
        props.put("mail.smtp.port", "587"); // replace with your email server port

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, app_password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateRandomCode() {
        return RandomStringUtils.randomAlphanumeric(16); // Increased the length for better security
    }

    public static void main(String[] args) {
        EmailSender emailSender = new EmailSender();
        emailSender.sendVerificationEmail("abdrahemenejouini@gmail.com");
        emailSender.sendPasswordResetEmail("abdrahemenejouini@gmail.com");
    }
}
