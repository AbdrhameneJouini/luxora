<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="com.luxora.beans.Commentaire" %>
    <% Commentaire comm = (Commentaire) request.getAttribute("comm"); %>
    <% if (comm != null) { %>
<h2><%= comm.getTexte() %></h2>    else { %>
        <p>Aucun comm trouvé</p>
    <% } %>

</body>
</html>