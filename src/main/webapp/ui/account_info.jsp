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
                    <h2 style="text-transform: uppercase" align="center"> ${user.login} <fmt:message
                            key="accounts"/></h2>
                    <p style="text-transform: uppercase" align="center"><a href="create_credit_account" class="link">
                        <fmt:message key="account.new.credit"/> </a></p>
                    <p style="text-transform: uppercase" align="center"><a href="create_debit_account" class="link">
                        <fmt:message key="account.new.debit"/> </a></p>
                    <p style="text-transform: uppercase" align="center"><a href="manage_accounts" class="link">
                      Manage accounts </a></p>
                </div>
                <div class="section group">
                    <c:forEach items="${acc}" var="ca">
                        <div class="grid_1_of_4 images_1_of_4">
                            <h4><p><fmt:message key="credit_acc1"/> **${ca.accountId}</p></h4>
                            <p><fmt:message key="credit_acc_status"/> ${ca.status}</p><br/>
                            <p><fmt:message key="credit_acc2"/> ${ca.balance}$</p><br/>
                            <p><fmt:message key="credit_acc3"/> ${ca.creditLimit}$</p><br/>
                            <p><fmt:message key="credit_acc4"/> ${ca.debt}$</p><br/>
                            <p><fmt:message key="credit_acc5"/> ${ca.percentage}%</p><br/>
                            <p><fmt:message key="credit_acc6"/> ${ca.creditRate}</p><br/>
                            <p><fmt:message key="credit_acc7"/> ${ca.depositStart}</p><br/>
<%--                            <p><fmt:message key="credit_acc8"/> ${ca.depositEnd}</p><br/>--%>
                            <p><fmt:message key="credit_acc9"/> ${ca.depositDuration}</p><br/>
<%--                            <a href="account_info" class="link"><fmt:message key="acc.delete"/></a>--%>
<%--                            <a href="account_info" class="link"><fmt:message key="acc.update"/></a>--%>
<%--                            <a href="account_info" class="link"><fmt:message key="acc.save"/></a>--%>
                        </div>
                    </c:forEach>
                    <c:forEach items="${debit_acc}" var="da">
                        <div class="grid_1_of_4 images_1_of_4">
                            <h4><p><fmt:message key="debit.acc1"/> **${da.accountId} </p></h4>
                            <p><fmt:message key="credit_acc2"/> ${da.balance}$</p><br/>
                            <p><fmt:message key="debit.acc2"/> ${da.debitRate}%</p><br/>
                            <p><fmt:message key="debit.acc3"/> ${da.depositedSum}$</p><br/>
                            <p><fmt:message key="credit_acc7"/> ${da.depositStart}</p><br/>
<%--                            <p><fmt:message key="credit_acc8"/> ${da.depositEnd}</p><br/>--%>
                            <p><fmt:message key="credit_acc9"/> ${da.depositDuration}</p><br/>
<%--                            <a href="account_info" class="link"><fmt:message key="acc.delete"/></a>--%>
<%--                            <a href="account_info" class="link"><fmt:message key="acc.update"/></a>--%>
<%--                            <a href="account_info" class="link"><fmt:message key="acc.save"/></a>--%>
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



