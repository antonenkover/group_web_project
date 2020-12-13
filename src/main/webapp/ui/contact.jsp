<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>
<html>
<head>
    <!------ Head ------------------->
    <c:import url="jsp_common/head.jsp"/>
    <!------ End Head ------------------------->
</head>
<body>

<!------ Header ----------------->
<c:import url="jsp_common/header_contact.jsp"/>
<!------ End Header ----------------------->

<div class="main">
    <div class="wrap">
        <div class="about-top">
            <div class="about">
                <!------ Map ----------------->
                <c:import url="jsp_common/content_map.jsp"/>
                <!------ Map end ----------------------->
                <div class="contact">
                    <div class="col1 span_1_of_contact">
                        <div class="company_address">
                            <div class="contact-left">
                                <h3><fmt:message key="contact.address1"/></h3>
                                <p><fmt:message key="contact.fax1"/></p>
                                <p><fmt:message key="contact.num1"/></p>
                                <p><fmt:message key="contact.email1"/></p>
                            </div>
                            <div class="contact-left1">
                                <h3><fmt:message key="contact.address2"/></h3>
                                <p><fmt:message key="contact.fax2"/></p>
                                <p><fmt:message key="contact.num2"/></p>
                                <p><fmt:message key="contact.email2"/></p>
                            </div>
                            <div class="clear"></div>
                        </div>
                    </div>
                    <div class="col1 span_2_of_contact">
                        <div class="contact-form">
                            <h3><fmt:message key="contact.contactUs"/></h3>
                            <form method="post" action="contact-post.html">
                                <div>
                                    <span><label> <fmt:message key="contact.Name"/> </label></span>
                                    <span><input name="userName" type="text" class="textbox"></span>
                                </div>
                                <div>
                                    <span><label> <fmt:message key="contact.email"/> </label></span>
                                    <span><input name="userEmail" type="text" class="textbox"></span>
                                </div>
                                <div>
                                    <span><label> <fmt:message key="contact.subject"/> </label></span>
                                    <span><textarea name="userMsg"> </textarea></span>
                                </div>
                                <div>
                                    <a href="#" class="btn"> <fmt:message key="contact.submit"/> </a>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<!------ Footer ------------------->
<c:import url="jsp_common/footer.jsp"/>
<!------ Footer end ------------------------>
</body>
</html>



