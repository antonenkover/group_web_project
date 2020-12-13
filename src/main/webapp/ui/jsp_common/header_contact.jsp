<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>
<html>
<base href="${pageContext.request.contextPath}/">
<div class="header">
    <div class="wrap">
        <div class="header-top">
            <div class="logo">
                <h1><a href=""> <fmt:message key="header.name"/><br>
                </a></h1>
            </div>
            <div class="menu">
                <div class="cssmenu">
                    <ul>
                        <li><a href=""><span>
                            <fmt:message key="header.home"/><br>
                        </span></a></li>
                        <li class="active"><a href="contact"><span>
                            <fmt:message key="header.contact"/><br>
                        </span></a></li>
                        <li>
                            <c:choose>
                            <c:when test="${user==null}">
                            <a href="account_info"> <fmt:message key="header.login"/><br> </a>
                            </c:when>
                            <c:when test="${user.securityAccess=='USER'}">
                            <a href="account_info"> ${user.login} <fmt:message key="header.account"/><br> </a>
                        <li class="last"><a href="logout"> <fmt:message key="header.logout"/><br> </a>
                            </c:when>
                            <c:otherwise>
                            <a href="admin_account_info"> <fmt:message key="header.admin"/><br> </a>
                        <li class="last"><a href="logout"> <fmt:message key="header.logout"/><br> </a>
                            </c:otherwise>
                            </c:choose>
                            <div class="clear"></div>
                        <li><p><a href="language?locale=en">
                            <img src="ui/images/usa.png" height="30" width="50"> </a></p>
                            <p><a href="language?locale=ru">
                                <img src="ui/images/rus2.png" height="30" width="50"> </a></p></li>
                    </ul>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
</html>
