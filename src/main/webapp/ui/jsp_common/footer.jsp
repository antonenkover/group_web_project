<!doctype html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>
<base href="${pageContext.request.contextPath}/">
<html>
<footer class="footer">
    <div class="footer">
        <div class="wrap">
            <div class="footer-top">
                <div class="col_1_of_4 span_1_of_4">
                    <h3>
                        <fmt:message key="footer.info"/><br>
                    </h3>
                    <ul class="first">
                        <li><a href="contact">
                            <fmt:message key="footer.contact"/><br>
                        </a></li>
                    </ul>
                </div>
                <div class="col_1_of_4 span_1_of_4">
                    <h3><fmt:message key="footer.myaccount"/><br></h3>
                    <ul class="first">
                        <li><a href="account_info"> <fmt:message key="footer.youraccount"/><br> </a></li>
                    </ul>
                </div>
                <div class="col_1_of_4 span_1_of_4 footer-lastgrid">
                    <h3><fmt:message key="footer.contactus"/><br></h3>
                    <ul class="last">
                        <li><span> <fmt:message key="footer.num1"/><br> </span></li>
                        <li><span> <fmt:message key="footer.num2"/><br> </span></li>
                    </ul>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
</footer>
</html>