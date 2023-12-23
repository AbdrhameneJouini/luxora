<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Link Expired</title>

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

        .expired-box {
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

        .expired-message {
            font-size: 28px; /* Increased font size */
            margin-bottom: 30px; /* Increased margin */
            color: #FF0000; /* Red color for 'Expired' message */
        }

        .return-button {
            margin-top: 20px; /* Adjusted margin-top for better placement */
            padding: 10px 20px; /* Reduced padding for a smaller button */
            font-size: 16px; /* Reduced font size */
            background-color: #0056b3; /* Darker blue button color */
            color: #fff; /* White text color */
            border: none;
            border-radius: 8px; /* Rounded corners */
            cursor: pointer;
            transition: background-color 0.3s, box-shadow 0.3s; /* Smooth transitions */
        }

        .return-button:hover {
            background-color: #004080; /* Darker blue on hover */
            box-shadow: 0 0 30px rgba(0, 0, 0, 0.3); /* Increased intensity of shadow on hover */
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
    <div class="row justify-content-center align-items-center">
        <div class="col-md-8">
            <div class="expired-box">
                <a href="index.jsp" class="close-button">&#10006;</a>
                <p class="expired-message">This link is expired</p>
                <div class="additional-content">
                    The  link you used is no longer valid. Please request a new activation link.
                </div>
                <button onclick="returnToHome()" class="return-button">Return to Home</button>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS and Popper.js (you can remove this if not needed) -->
<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script>
    // Function to return to the home page
    function returnToHome() {
        // Redirect to the home page
        window.location.href = 'login.jsp';
    }
</script>

</body>
</html>
