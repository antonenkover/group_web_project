<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- Custom Theme files -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ui/css/registration.css">
    <link href="css/registration.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- //Custom Theme files -->
    <!-- web font -->
    <link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
    <!-- //web font -->
</head>
<body>
<!-- main -->
<div class="main-w3layouts wrapper">
    <h1>Login</h1>
    <div class="main-agileinfo">
        <div class="agileits-top">
            <form action="login" method="post">
                <input class="text" type="text" name="log" placeholder="Login" required="">
                <input class="text" type="password" name="pass" placeholder="Password" required="">
                <%--                <input class="text" type="text" name="name" placeholder="Name" required="">--%>
                <%--                <input class="text" type="text" name="surname" placeholder="Surname" required="">--%>
                <div class="wthree-text">
                    <%--                    <label class="anim">--%>
                    <%--                        <input type="checkbox" class="checkbox" required="">--%>
                    <%--                        <span>I Agree To The Terms & Conditions</span>--%>
                    <%--                    </label>--%>
                    <div class="clear"></div>
                </div>
                <input type="submit" value="LOGIN">
            </form>
            <%--            <p>Already have an Account? <a href="#"> Login</a></p>--%>
        </div>
    </div>
    <ul class="colorlib-bubbles">
        <li></li>
    </ul>
</div>
</body>
</html>