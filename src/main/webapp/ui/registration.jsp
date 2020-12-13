<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="register"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <base href="${pageContext.request.contextPath}/">
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
    <h1><fmt:message key="register"/></h1>
    <div class="main-agileinfo">
        <div class="agileits-top">
            <form action="registration" method="post">
                <input class="text" type="text" name="login" placeholder="<fmt:message key="placeholder.login"/>"
                       required=""></br>
                <c:choose>
                    <c:when test="${locale==en}">
                        <p> ${error_login_exists} </p> </br>
                    </c:when>
                    <c:otherwise>
                        <p> ${error_login_exists_ru} </p> </br>
                    </c:otherwise>
                </c:choose>
                <input class="text" type="password" name="password" placeholder="<fmt:message key="placeholder.pass"/>"
                       required=""></br>
                <input class="text" type="text" name="name" placeholder="<fmt:message key="placeholder.name"/>"
                       required=""></br>
                <input class="text" type="text" name="surname" placeholder="<fmt:message key="placeholder.surname"/>"
                       required=""></br>
                <div class="wthree-text">
                    <label class="anim">
                        <input type="checkbox" class="checkbox" required="">
                        <span><fmt:message key="conditions.agree"/></span>
                    </label>
                    <div class="clear"></div>
                </div>
                <input type="submit" value="<fmt:message key="signup"/>">
            </form>
            <p><fmt:message key="account.have"/> <a href="login"> <fmt:message key="login.submit"/></a></p>
        </div>
    </div>
    <ul class="colorlib-bubbles">
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>
</body>
</html>