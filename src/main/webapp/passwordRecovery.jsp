<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Password Reset</title>

    <!-- Bootstrap CSS -->
    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(to right, #FBF6EE, #D4E6F1);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        .reset-box {
            text-align: center;
            padding: 60px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.4);
            background-color: #ffffff;
            color: #333;
            max-width: 700px;
            min-height: 350px;
            width: 80%;
            margin-top: -20px;
            margin-left: 10%;
            position: relative;
        }

        .reset-message {
            font-size: 28px;
            margin-bottom: 30px;
        }

        .reset-text {
            font-size: 18px;
            color: #333;
        }

        .form-group {
            text-align: left;
            margin-bottom: 20px;
        }

        .label {
            margin-top: 10px;
            padding-right: 10px;
            font-weight: bold;
        }

        .form-control {
            width: 100%;
            display: block;
        }

        .submit-button {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            margin-top: 2%;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .submit-button:hover {
            background-color: #004080;
        }

        .error-message {
            color: #ff0000;
            font-size: 14px;
            margin-top: 5px;
        }

        .close-button {
            position: absolute;
            top: 10px;
            right: 10px;
            font-size: 20px;
            cursor: pointer;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row justify-content-center align-items-center">
        <div class="col-md-8">

            <div class="reset-box">
                <span class="close-button" onclick="goToHomePage()">&times;</span>
                <p class="reset-message">Reset your password.
                    <br>
                    <span class="reset-text">Enter your new password below.</span>
                </p>

                <form id="resetForm" action="PasswordRecovery" method="get">
                    <input type="hidden" name="token" value="<%= request.getParameter("token") %>">
                    <div class="form-group">
                        <label for="newPassword" class="label">Password :</label>
                        <input type="password" id="newPassword" name="newPassword" class="form-control" placeholder="Enter your new password" required>
                    </div>

                    <div class="form-group">
                        <label for="confirmPassword" class="label">Confirm Password :</label>
                        <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" placeholder="Confirm your new password" required>
                        <div id="passwordMismatchError" class="error-message">Passwords do not match.</div>
                    </div>

                    <button type="submit" class="submit-button" id="submitButton" disabled>Reset Password</button>
                </form>

            </div>

        </div>
    </div>
</div>

<!-- Bootstrap JS and Popper.js (you can remove this if not needed) -->
<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<script>
    function goToHomePage() {
        window.location.href = "index.jsp";
    }

    document.getElementById("confirmPassword").addEventListener("input", function () {
        var newPassword = document.getElementById("newPassword").value;
        var confirmPassword = document.getElementById("confirmPassword").value;
        var passwordMismatchError = document.getElementById("passwordMismatchError");
        var submitButton = document.getElementById("submitButton");

        if (newPassword === confirmPassword) {
            passwordMismatchError.style.display = "none";
            submitButton.disabled = false;
        } else {
            passwordMismatchError.style.display = "block";
            submitButton.disabled = true;
        }
    });
</script>

</body>
</html>
