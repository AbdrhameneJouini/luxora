<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>RegistrationForm_v1 by Colorlib</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- MATERIAL DESIGN ICONIC FONT -->
    <link rel="stylesheet" href="resources/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

    <!-- STYLE CSS -->
    <link rel="stylesheet" href="resources/css/style.css">
    <style>
        .alert {
            padding: 1rem 1.25rem;
            margin-bottom: 1rem;
            border: 1px solid transparent;
            border-radius: 0.25rem;
        }

        .alert-danger {
            color: #842029;
            background-color: #f8d7da;
            border-color: #f5c2c7;
        }

        .alert-hidden {
            display: none;
        }



        .close-button {
            position: absolute;
            top: 20px;
            right: 20px;
            font-size: 20px;
            color: #111111;
            text-decoration: none;
        }
    </style>
</head>

<body>

<div class="wrapper" style="background-image: url('resources/images/bg-registration-form-1.jpg');">

    <div class="inner">

        <div class="image-holder">
            <img src="resources/images/Signup_picture.jpg" alt="">
        </div>
        <a href="index.jsp" class="close-button">&#10006;</a>
        <form action="Signup" method="get" onsubmit="return validateForm()">

            <h3>Registration Form</h3>
            <div class="form-group">
                <input type="text" placeholder="First Name" class="form-control" name="firstName" required>
                <input type="text" placeholder="Last Name" class="form-control" name="lastName" required>
            </div>
            <div class="form-wrapper">
                <input type="text" placeholder="Username" class="form-control" name="userName" required>
                <i class="zmdi zmdi-account"></i>
            </div>
            <div class="form-wrapper">
                <input type="text" id="email" placeholder="Email Address" class="form-control" name="email" onblur="checkEmail(this.value)" required>
                <i class="zmdi zmdi-email"></i>
            </div>
            <div class="form-wrapper">
                <input type="text" placeholder="Address" class="form-control"  name="address" required>
                <i class="zmdi zmdi-home"></i>
            </div>
            <div class="form-wrapper">
                <select name="gender" id="" class="form-control" required>
                    <option value="" disabled selected>Gender</option>
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                    <option value="other">Other</option>
                </select>
                <i class="zmdi zmdi-caret-down" style="font-size: 17px"></i>
            </div>
            <div class="form-wrapper">
                <input type="password" id="password" name="password" placeholder="Password" class="form-control" required>
                <i class="zmdi zmdi-lock"></i>
            </div>
            <div class="form-wrapper">
                <input type="password" id="confirmPassword" placeholder="Confirm Password" class="form-control" required>
                <i class="zmdi zmdi-lock"></i>
            </div>
            <div class="alert alert-danger alert-hidden" role="alert" id="password_mismatch">
                Please make sure that passwords are identical!
            </div>
            <div class="alert alert-danger alert-hidden" role="alert" id="email_not_valid">
                Please enter a valid and email address!
            </div>
            <div class="alert alert-danger alert-hidden" role="alert" id="email_not_unique">
                This email is already in use!
            </div>
            <button type="submit" id="signupButton" disabled>Register
                <i class="zmdi zmdi-arrow-right"></i>
            </button>
        </form>
    </div>
    <%
        // Get the context path
        String contextPath = request.getContextPath();
        // Set it as a JavaScript variable
        System.out.println("<script>var contextPath = '" + contextPath + "';</script>");
    %>
</div>

<script>

    function validateForm() {
        var password = document.getElementById("password").value;
        var confirmPassword = document.getElementById("confirmPassword").value;
        var email = document.getElementById("email").value;

        // Check for password mismatch
        if (password !== confirmPassword) {
            document.getElementById("password_mismatch").classList.remove("alert-hidden");
            return false;
        } else {
            document.getElementById("password_mismatch").classList.add("alert-hidden");
        }

        // Check for valid email format
        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!email.match(emailRegex)) {
            document.getElementById("email_not_valid").classList.remove("alert-hidden");
            return false;
        } else {
            document.getElementById("email_not_valid").classList.add("alert-hidden");
        }

        // Check if email is unique
        return checkEmail(email);
    }

    function checkEmail(email) {

        var contextPath = '<%= request.getContextPath() %>';

        var xhr = new XMLHttpRequest();
        xhr.open('GET', contextPath + '/CheckEmail?email=' + email, false);
        xhr.send();

        var emailExists = xhr.responseText === 'true';
        var emailExistsAlert = document.getElementById("email_not_unique");
        var signupButton = document.getElementById("signupButton");

        if (emailExists) {
            emailExistsAlert.classList.remove("alert-hidden");
            signupButton.disabled = true;
            return false;
        } else {
            emailExistsAlert.classList.add("alert-hidden");
            signupButton.disabled = false;
            return true;
        }


    }
</script>

</body>
</html>
