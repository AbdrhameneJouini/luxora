<%--
  Created by IntelliJ IDEA.
  User: abdou
  Date: 12/25/2023
  Time: 7:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.luxora.beans.Commentaire" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
 <form method="get" action="GetArticleComments">
    <button type="submit">press me</button>



 </form>

 <%
     List<Commentaire> articleComments = (List<Commentaire>) request.getAttribute("articleComments");

     if (articleComments != null && !articleComments.isEmpty()) {
         for (Commentaire comment : articleComments) {
 %>
 <p><strong><%= comment.getTexte() %></strong></p>
 <%
     }
 } else {
 %>
 <p>No comments available for this article.</p>
 <%
     }
 %>
</body>
</html>
