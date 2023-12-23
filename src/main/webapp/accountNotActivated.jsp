<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Activation</title>

    <!-- Bootstrap CSS -->
    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(to right, #FBF6EE, #D4E6F1); /* Gradient background */
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; /* Modern font */
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        .activation-box {
            text-align: center;
            padding: 60px; /* Increased padding for a bigger box */
            border-radius: 12px; /* Rounded corners */
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.4); /* Increased intensity of shadow */
            background-color: #ffffff; /* White background color */
            color: #333; /* Dark text color */
            max-width: 700px; /* Adjusted max-width */
            min-height: 350px;
            width: 80%; /* Adjusted width */
            margin-top: -20px; /* Adjusted margin to center the box exactly in the middle */
            margin-left: 10%;
            position: relative; /* Added relative positioning */
        }

        .activation-message {
            font-size: 28px; /* Increased font size */
            margin-bottom: 30px; /* Increased margin */
        }

        .waiting-text {
            font-size: 36px;
            font-weight: bold;
            color: #FF8C00; /* Orange color for 'Waiting' */
        }

        .resend-link,
        .change-email-link {
            color: #44a9ad; /* Blue link color */
            cursor: pointer;
            text-decoration: none; /* Removed underline */
            margin-top: 10px;
            margin-right: 30px;
            margin-left:  25px;
            display: inline-block;
            transition: color 0.5s; /* Smooth transition on color change */
            font-size: 20px;
        }

        .resend-link:hover,
        .change-email-link:hover {
            color: #0f2d4b; /* Darker blue on hover */
        }

        .hidden-form {
            display: none;
            margin-top: 20px;
        }

        .hidden-input {
            margin-top: 10px;
            display: block;
            width: 100% ; /* Adjusted width */
            padding: 8px;
            box-sizing: border-box;
            margin-bottom: 10px;
        }

        .submit-button {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .submit-button:hover {
            background-color: #004080;
        }

        .close-button-input {
            position: absolute;
            top: 10px;
            right: 10px;
            font-size: 20px;
            cursor: pointer;
            margin-top: 41%; /* Adjusted margin to be closer to the input */
            margin-right: 10%; /* Adjusted margin to be closer to the input */
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

<div class="container">

    <div class="row justify-content-center align-items-center"> <!-- Centered both horizontally and vertically -->
        <div class="col-md-8"> <!-- Adjusted column width -->
            <a href="index.jsp" class="close-button">&#10006;</a>
            <!-- Account Activation Box -->
            <div class="activation-box">



                <!-- Activation Message -->
                <p class="activation-message">Your account is
                    <br>
                    <span class="waiting-text">waiting</span> to be activated.</p>

                <!-- Resend Activation Link -->
                <p class="resend-link" onclick="resendActivation()">Resend activation email</p>

                <!-- Change Email Link -->
                <p class="change-email-link" onclick="showChangeEmailForm()">Change email address</p>

                <!-- Hidden Form for Changing Email -->
                <form class="hidden-form" id="changeEmailForm" method="get" action="Activation_ChangeEmail">
                    <input type="hidden" name="token" id="token" value="<%= request.getParameter("token") %>">
                    <span class="close-button-input" onclick="hideChangeEmailForm()">&times;</span>
                    <label for="newEmail" class="hidden-input"></label>
                    <input type="email" id="newEmail" name="newEmail" class="form-control hidden-input" placeholder="Enter new email">
                    <button type="submit" class="submit-button">Submit</button>
                </form>

            </div>

        </div>
    </div>
</div>

<!-- Bootstrap JS and Popper.js (you can remove this if not needed) -->
<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<script>
    function resendActivation() {


        // Retrieve the email from the hidden input
        var token = document.getElementById("token").value;
        console.log("the token is " + token);
        var contextPath = '<%= request.getContextPath() %>';
        // Create an AJAX request


        var xhr = new XMLHttpRequest();
        xhr.open('GET', contextPath + '/ReSendActivation?token=' + token, false);
        xhr.send();




    }


    function showChangeEmailForm() {
        // Show the hidden form for changing email
        document.getElementById("changeEmailForm").style.display = "block";
    }

    function hideChangeEmailForm() {
        // Hide the form for changing email
        document.getElementById("changeEmailForm").style.display = "none";
    }
</script>

</body>
</html>
