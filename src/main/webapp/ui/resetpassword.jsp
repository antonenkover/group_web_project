<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Login Form</title>
    <link href="css/loginStyle.css" rel="stylesheet" type="text/css" media="all"/>
    <!--[if lt IE 9]><![endif]-->
</head>
<body>
<section class="container">
    <div class="login">
        <h1>Reset Password</h1>
        <form id="resetForm" action="reset_password" method="post">
            <label><fmt:message key="reset.writeEmail"/><br></label>
            <p><input type="text" name="email" value="" placeholder="Email"></p>
            <p class="submit2"><input type="submit" name="commit" value="Send Password"></p>
        </form>
        </form>
    </div>
    <div class="login-help">
        <p><a href="index"><fmt:message key="goBack"/><br></a>.</p>
    </div>
</section>
</section>
</body>
</html>
