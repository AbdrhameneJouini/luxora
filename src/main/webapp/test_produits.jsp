<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.luxora.beans.Article" %>

<!DOCTYPE html>
<html>
<head>
    <title>Article List</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
        $(document).ready(function () {
            function fetchData() {
                $.ajax({
                    type: 'GET',
                    url: 'GetAllProducts',
                    dataType: 'json',
                    success: function (data) {
                        displayData(data);
                    },
                    error: function () {
                        console.error('Error fetching data');
                    }
                });
            }

            function displayData(articleList) {
                if (articleList.length > 0) {
                    for (var i = 0; i < articleList.length; i++) {
                        var article = articleList[i];
                        $('#articleList').append('<div><h3>hii' + article.getNom_Article() + '</h3><p>' + article.getSomeOtherProperty() + '</p></div>');
                        // Add more properties as needed
                    }
                } else {
                    $('#articleList').append('<p>No articles available.</p>');
                }
            }

            fetchData();
        });
    </script>
</head>
<body>
<h2>Article List</h2>
<div id="articleList"></div>
</body>
</html>
