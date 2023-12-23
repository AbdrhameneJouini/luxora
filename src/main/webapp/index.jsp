<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>



<br/><br/><br/>
<a href="login.jsp">go to login page</a>
<br/><br/><br/>
<a href="login_old.jsp">go to old login page</a>
<br/><br/><br/>
<a href="signup.jsp">go to signup page</a>
<br/><br/><br/>
<a href="test.jsp">go to test page</a>
<br/><br/><br/>
<a href="accountActivated.jsp">go to account activated page</a>
<br/><br/><br/>
<a href="accountNotActivated.jsp">go to account not activated page</a>
<br/><br/><br/>
<a href="accountSuspended.jsp">go to account suspended page</a>
<br/><br/><br/>
<a href="forgotPassword.jsp">go to password forget password page</a>
<br/><br/><br/>
<a href="passwordRecovery.jsp">go to password  recovery page</a>
<br/><br/><br/>
<a href="linkExpired.jsp">go to link expired page</a>
<br/><br/><br/>
<a href="test.jsp">go to test product page</a>
<br/><br/><br/>
<a href="homepage.jsp">go to Home page</a>
<br/><br/><br/>



<div class="input-group mb-3">
    <span class="input-group-text" id="basic-addon1">@</span>
    <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
    <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="basic-addon2">
    <span class="input-group-text" id="basic-addon2">@example.com</span>
</div>

<div class="mb-3">
    <label for="basic-url" class="form-label">Your vanity URL</label>
    <div class="input-group">
        <span class="input-group-text" id="basic-addon3">https://example.com/users/</span>
        <input type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3 basic-addon4">
    </div>
    <div class="form-text" id="basic-addon4">Example help text goes outside the input group.</div>
</div>

<div class="input-group mb-3">
    <span class="input-group-text">$</span>
    <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
    <span class="input-group-text">.00</span>
</div>

<div class="input-group mb-3">
    <input type="text" class="form-control" placeholder="Username" aria-label="Username">
    <span class="input-group-text">@</span>
    <input type="text" class="form-control" placeholder="Server" aria-label="Server">
</div>

<div class="input-group">
    <span class="input-group-text">With textarea</span>
    <textarea class="form-control" aria-label="With textarea"></textarea>
</div>
</body>
</html>