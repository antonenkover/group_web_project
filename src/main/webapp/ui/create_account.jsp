<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>
<!DOCTYPE html>
<html>
<head>
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
<!-- web font -->
<link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
<!-- //web font -->
</head>
<body>

    <script type="text/javascript">
        window.onload = function () {
            document.getElementById('ifYes').style.display = 'none';
            document.getElementById('ifNo').style.display = 'none';
        }

        function yesnoCheck() {
            if (document.getElementById('yesCheck').checked) {
                document.getElementById('ifYes').style.display = 'block';
                document.getElementById('ifNo').style.display = 'none';
            } else if (document.getElementById('noCheck').checked) {
                document.getElementById('ifNo').style.display = 'block';
                document.getElementById('ifYes').style.display = 'none';
            }
        }
    </script>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            $("#datepicker").datepicker({dateFormat: 'yy-mm-dd'});
        });
        $(function () {
            $("#datepicker2").datepicker({dateFormat: 'yy-mm-dd'});
        });
    </script>
    <title><fmt:message key="create.acc"/></title>
<!-- main -->
<div class="main-w3layouts wrapper">
    <h1><fmt:message key="account.new"/></h1>
    <div class="main-agileinfo">
        <div class="agileits-top">
            <form action="create_account" method="post">
                <h1><fmt:message key="acc.action"/></h1></br>
                <div class="wthree-text">
                    <label class="anim">
                        <input type="radio" onclick="yesnoCheck();" name="yesno" id="yesCheck">
                        <span><fmt:message key="acc.deposit"/>t</span></br>
                        </br>
                    </label>
                    <label class="anim">
                        <input type="radio" onclick="yesnoCheck();" name="yesno" id="noCheck">
                        <span><fmt:message key="acc.credit"/></span>
                        <br/>
                        <br/>
                        <br/>
                        <div class="clear"></div>
                    </label>
                </div>
                <div id="ifYes" style="display:none">
                    <input type="text" name="deb_rate" placeholder="<fmt:message key="debit.acc2"/>"> </br>
                    <input type="text" name="dep_sum" placeholder="<fmt:message key="debit.acc3"/>"></br>
                    <input type="text" id="datepicker" name="start_date" placeholder="<fmt:message key="acc.start"/>"></br>
                    <input type="text" name="dep_dur" placeholder="<fmt:message key="credit_acc9"/>">
                </div>
                <div id="ifNo" style="display:none">
                    <input class="text" type="text" name="deb" placeholder="<fmt:message key="credit_acc3"/>"></br>
                    <input class="text" type="text" name="login" placeholder="<fmt:message key="acc.percentage"/>"></br>
                    <input class="text" type="text" id="datepicker2" name="name"
                           placeholder="<fmt:message key="acc.start"/>"></br>
                    <input class="text" type="text" name="login" placeholder="<fmt:message key="credit_acc9"/>">
                </div>
                <input type="submit" name="send1" style="text-transform: uppercase"
                       value="Submit"/>
            </form>
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