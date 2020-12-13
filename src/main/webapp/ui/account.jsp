<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<base href="${pageContext.request.contextPath}/">--%>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
<head>
    <!------ Head ------------------->
    <c:import url="jsp_common/head.jsp"/>
    <!------ End Head ------------------------->
</head>
<body>

<!------ Header ----------------->
<c:import url="jsp_common/header_account.jsp"/>
<!------ End Header ----------------------->

<div class="main">
    <div class="wrap">
        <div class="about-top">
            <div class="about">
                <div class="heading4">
                    <h2>Our Services</h2>
                </div>
                <div class="section group">
                    <%--                    <p> ${acc} </p>--%>
                    <%--                    <c:forEach items="${acc}" var="student">--%>
                    <%--                            <p>${student.balance}</p><br/>--%>
                    <%--                            <p>${student.creditLimit}</p><br/>--%>
                    <%--                            <p>${student.debt}</p><br/>--%>
                    <%--                            <p>${student.percentage}</p><br/>--%>
                    <%--                            <p>${student.creditRate}</p><br/>--%>
                    <%--                            <p>${student.depositStart}</p><br/>--%>
                    <%--                            <p>${student.depositEnd}</p><br/>--%>
                    <%--                            <p>${student.depositDuration}</p><br/>--%>
                    <%--                        </c:forEach>--%>
                    <div class="grid_1_of_4 images_1_of_4">
                        <a href="ui/images/t-pic5.jpg" class="swipebox" title="Image Title"> <img
                                src="ui/images/pic5.jpg" alt=""><span class="zoom-icon"></span> </a>
                        <h4>Aenean nonummy hendrerit</h4>
                        <p>Praesent vestibulum molestie lacus. Aenean nonummy hendrerit mauris. Phasellus porta. Fusce
                            suscipit varius mi. Cum sociis natoque penatibus et magnis dis parturient.</p>
                        <a href="#" class="link">Read More</a>
                    </div>
                    <div class="grid_1_of_4 images_1_of_4">
                        <%--                        <a href="ui/images/t-pic6.jpg" class="swipebox" title="Image Title"> <img src="ui/images/pic6.jpg" alt=""><span class="zoom-icon"></span> </a>--%>
                        <%--                        <h4>Aenean nonummy hendrerit</h4>--%>
                        <%--                        <p>Praesent vestibulum molestie lacus. Aenean nonummy hendrerit mauris. Phasellus porta. Fusce suscipit varius mi. Cum sociis natoque penatibus et magnis dis parturient.</p>--%>
                        <%--                        <a href="#" class="link">Read More</a>--%>
                    </div>
                    <div class="grid_1_of_4 images_1_of_4">
                        <%--                        <a href="ui/images/t-pic7.jpg" class="swipebox" title="Image Title"> <img src="ui/images/pic7.jpg" alt=""><span class="zoom-icon"></span> </a>--%>
                        <%--                        <h4>Aenean nonummy hendrerit</h4>--%>
                        <%--                        <p>Praesent vestibulum molestie lacus. Aenean nonummy hendrerit mauris. Phasellus porta. Fusce suscipit varius mi. Cum sociis natoque penatibus et magnis dis parturient.</p>--%>
                        <%--                        <a href="#" class="link">Read More</a>--%>
                    </div>
                    <div class="grid_1_of_4 images_1_of_4">
                        <%--                        <a href="ui/images/t-pic8.jpg" class="swipebox" title="Image Title"> <img src="ui/images/pic8.jpg" alt=""><span class="zoom-icon"></span> </a>--%>
                        <%--                        <h4>Aenean nonummy hendrerit</h4>--%>
                        <%--                        <p>Praesent vestibulum molestie lacus. Aenean nonummy hendrerit mauris. Phasellus porta. Fusce suscipit varius mi. Cum sociis natoque penatibus et magnis dis parturient.</p>--%>
                        <%--                        <a href="#" class="link">Read More</a>--%>
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



