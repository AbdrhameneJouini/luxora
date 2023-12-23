<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Password Recovery</title>

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

        .recovery-box {
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

        .recovery-message {
            font-size: 28px; /* Increased font size */
            margin-bottom: 30px; /* Increased margin */
        }

        .recovery-text {
            font-size: 18px;
            color: #333; /* Dark text color */
        }

        .recovery-link {
            color: #44a9ad; /* Blue link color */
            cursor: pointer;
            text-decoration: none; /* Removed underline */
            margin-top: 20px;
            display: inline-block;
            transition: color 0.5s; /* Smooth transition on color change */
            font-size: 20px;
        }

        .recovery-link:hover {
            color: #0f2d4b; /* Darker blue on hover */
        }

        .submit-button {
            display: block;

            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            margin-top: 1%;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .submit-button:hover {
            background-color: #004080;
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
            <!-- Password Recovery Box -->
            <div class="recovery-box">

                <!-- Recovery Message -->
                <p class="recovery-message">Forgot your password?
                    <br>
                    <span class="recovery-text">Enter your email to reset it.</span>
                </p>

                <!-- Recovery Form -->
                <form id="recoveryForm" method="get" action="ForgotPassword">

                    <label for="recoveryEmail" class="hidden-input"></label>
                    <input type="email" id="recoveryEmail" name="recoveryEmail" class="form-control hidden-input" placeholder="Enter your email">
                    <button type="submit" class="submit-button">Reset Password</button>
                </form>

                <!-- Recovery Link -->
                <p class="recovery-link" onclick="window.location.href='login.jsp'">Back to Log in</p>

            </div>

        </div>
    </div>
</div>

<!-- Bootstrap JS and Popper.js (you can remove this if not needed) -->
<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>



</body>
</html>
