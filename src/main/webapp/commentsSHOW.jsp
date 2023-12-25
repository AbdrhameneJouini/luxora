<%@ page import="java.util.List" %>
<%@ page import="com.luxora.beans.Commentaire" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

    <title>Chat - Apps | Vuexy - Bootstrap Admin Template</title>

    <meta name="description" content="" />

    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="assets/img/favicon/favicon.ico" />

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet" />

    <!-- Icons -->
    <link rel="stylesheet" href="assets/vendor/fonts/fontawesome.css" />
    <link rel="stylesheet" href="assets/vendor/fonts/tabler-icons.css" />
    <link rel="stylesheet" href="assets/vendor/fonts/flag-icons.css" />

    <!-- Core CSS -->
    <link rel="stylesheet" href="assets/vendor/css/rtl/core.css" />
    <link rel="stylesheet" href="assets/vendor/css/rtl/theme-default.css" />
    <link rel="stylesheet" href="assets/css/demo.css" />

    <!-- Vendors CSS -->
    <link rel="stylesheet" href="assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css" />
    <link rel="stylesheet" href="assets/vendor/libs/node-waves/node-waves.css" />
    <link rel="stylesheet" href="assets/vendor/libs/typeahead-js/typeahead.css" />
    <link rel="stylesheet" href="assets/vendor/libs/bootstrap-maxlength/bootstrap-maxlength.css" />

    <!-- Page CSS -->

    <link rel="stylesheet" href="assets/vendor/css/pages/app-chat.css" />
    <!-- Helpers -->
    <script src="assets/vendor/js/helpers.js"></script>

    <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
    <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
    <script src="assets/js/config.js"></script>
</head>
<body>
<h2>Article Comments</h2>

<%
    List<Commentaire> articleComments = (List<Commentaire>) request.getAttribute("articleComments");

    if (articleComments != null && !articleComments.isEmpty()) {
        for (Commentaire comment : articleComments) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date commentDate = sdf.parse(comment.getDate());

            Calendar now = Calendar.getInstance();
            Calendar commentCalendar = Calendar.getInstance();
            commentCalendar.setTime(commentDate);

            long timeDifferenceInMillis = now.getTimeInMillis() - commentCalendar.getTimeInMillis();
            long seconds = timeDifferenceInMillis / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            long days = hours / 24;
            long months = days / 30;

            String timeAgo = "";

            if (months > 0) {
                timeAgo = months + (months == 1 ? " month ago" : " months ago");
            } else if (days > 0) {
                timeAgo = days + (days == 1 ? " day ago" : " days ago");
            } else if (hours > 0) {
                timeAgo = hours + (hours == 1 ? " hour ago" : " hours ago");
            } else if (minutes > 0) {
                timeAgo = minutes + (minutes == 1 ? " minute ago" : " minutes ago");
            } else {
                timeAgo = seconds + (seconds == 1 ? " second ago" : " seconds ago");
            }

%>
<div class="card mb-3" style="width: 400px ; height: 75px">



    <div class="card-body d-flex justify-content-between">
      <%--  <span class="me-2"><strong>   {commentID}   <%= comment.getId_commentaire() %> </strong> :</span>
        <span class="me-2"><strong>   {parentID}   <%= comment.getref_comm() %> </strong> :</span>--%>
        <div class="d-flex align-items-center">

            <img src="assets/img/avatars/1.png" alt="Avatar" width="25px" height="25px" class="rounded-circle">
            <span class="me-2"><strong>   {userId}   <%= comment.getId_uti() %> </strong> :</span>
            <p class="card-text"><%= comment.getTexte() %></p>
        </div>

        <div>
            <span><small style="color: grey"><%= timeAgo %></small></span>
        </div>

    </div>


    <!-- Sub-comments -->
    <div class="card-footer">
        <div class="ms-4"> <!-- Add margin to sub-comments -->
            <%-- Display sub-comments here, adjust the structure as needed --%>
        </div>
    </div>
</div>
<%
    }
} else {
%>
<p>No comments available for this article.</p>
<%
    }
%>

<!-- Core JS -->
<!-- build:js assets/vendor/js/core.js -->
<script src="assets/vendor/libs/jquery/jquery.js"></script>
<script src="assets/vendor/libs/popper/popper.js"></script>
<script src="assets/vendor/js/bootstrap.js"></script>
<script src="assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="assets/vendor/libs/node-waves/node-waves.js"></script>

<script src="assets/vendor/libs/hammer/hammer.js"></script>
<script src="assets/vendor/libs/i18n/i18n.js"></script>
<script src="assets/vendor/libs/typeahead-js/typeahead.js"></script>

<script src="assets/vendor/js/menu.js"></script>
<!-- endbuild -->

<!-- Vendors JS -->
<script src="assets/vendor/libs/bootstrap-maxlength/bootstrap-maxlength.js"></script>

<!-- Main JS -->
<script src="assets/js/main.js"></script>

<!-- Page JS -->
<script src="assets/js/app-chat.js"></script>
</body>
</html>