<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page  import ="com.luxora.beans.Article" %>
    <%@ page  import =" java.util.ArrayList" %>
    <%@ page  import =" java.util.List" %>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <div class="title">
    	<h1>Deals of the day</h1>
    </div>
<c:forEach var="produit" items="${products}">x
<div class="container-prod">

    <img src="resources/images/tempHomepage/shirt.jpg" alt="Women Hot Collection" class="responsive-img-prod">
    <p>${produit.getNomp()}</p>
    <p>${produit.getReference()}</p>
    <p>${produit.getPrix()}</p>
    <ul class="header-social-container">

          <li>
            <a href="#" class="social-link">
              <i class="fa-regular fa-eye"></i>
            </a>
          </li>

          <li>
            <a href="#" class="social-link">
              <i class="fa-regular fa-heart"></i>
            </a>
          </li>

          <li>
            <a href="#" class="social-link">
              <i class="fa-solid fa-cart-shopping"></i>
            </a>
          </li>
          </ul>
 </div>
</c:forEach>
 <p>pas de produit</p>