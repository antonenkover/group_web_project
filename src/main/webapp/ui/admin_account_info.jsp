<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>
<html>
<base href="${pageContext.request.contextPath}/">
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
                    <h2 style="text-transform: uppercase" align="center"> ${user.login} REVIEWING <fmt:message
                            key="accounts"/> INFO </h2>
                </div>
                <div class="section group">
                    <c:forEach items="${users}" var="us">
                        <div class="grid_1_of_4 images_1_of_4">
                            <h4><p><fmt:message key="placeholder.name"/>: ${us.name}</p></h4>
                            <h4><p><fmt:message key="placeholder.surname"/>: ${us.surname}</p></h4>
                            <h4><p><fmt:message key="credit_acc1"/>: **${us.accountId}</p></h4>
                            <p><fmt:message key="credit_acc_status"/> ${us.status}</p><br/>
                            <p><fmt:message key="credit_acc2"/> ${us.balance}$</p><br/>
                            <p><fmt:message key="credit_acc3"/> ${us.creditLimit}$</p><br/>
                            <p><fmt:message key="credit_acc4"/> ${us.debt}$</p><br/>
                            <p><fmt:message key="credit_acc5"/> ${us.percentage}%</p><br/>
                            <p><fmt:message key="credit_acc6"/> ${us.creditRate}</p><br/>
                            <p><fmt:message key="credit_acc7"/> ${us.depositStart}</p><br/>
<%--                            <p><fmt:message key="credit_acc8"/> ${us.depositEnd}</p><br/>--%>
                            <p><fmt:message key="credit_acc9"/> ${us.depositDuration}</p><br/>
                            <c:choose>
                            <c:when test="${us.status=='REVIEWING'}">
                                <div class="agileits-top">
                                    <input type="submit" name="commit" style="text-transform: uppercase"
                                           value="Approve">
                                    <input type="submit" name="commit" style="text-transform: uppercase"
                                           value="Decline">
                                </div>
                             </c:when>
                            </c:choose>
                        </div>
                    </c:forEach>
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



