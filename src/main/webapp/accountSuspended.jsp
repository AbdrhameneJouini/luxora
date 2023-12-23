<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Suspended</title>

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

        .suspended-box {
            text-align: center;
            padding: 60px; /* Increased padding for a bigger box */
            border-radius: 12px; /* Rounded corners */
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.4); /* Increased intensity of shadow */
            background-color: #ffffff; /* White background color */
            color: #333; /* Dark text color */
            max-width: 700px; /* Adjusted max-width */
            height: 350px;
            width: 80%; /* Adjusted width */
            margin-top: -20px; /* Adjusted margin to center the box exactly in the middle */
            margin-left: 10%;
        }

        .suspended-message {
            font-size: 28px; /* Increased font size */
            margin-bottom: 30px; /* Increased margin */
        }

        .suspended-text {
            font-size: 36px;
            font-weight: bold;
            color: #FF0000; /* Red color for 'Suspended' */
        }

        .contact-info {
            font-size: 18px;
            color: #555;
            margin-top: 20px;
        }

        .contact-email {
            color: #007bff; /* Blue color for email */
            font-weight: bold;
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
            <!-- Account Suspended Box -->
            <div class="suspended-box">

                <!-- Suspended Message -->
                <p class="suspended-message">Your account has been
                    <br>
                    <span class="suspended-text">suspended</span>.</p>

                <!-- Contact Information -->
                <p class="contact-info">For more information, please contact support at <span class="contact-email">eCommerce.smtp.polytech@gmail.com</span></p>

            </div>

        </div>
    </div>
</div>

<!-- Bootstrap JS and Popper.js (you can remove this if not needed) -->
<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>
