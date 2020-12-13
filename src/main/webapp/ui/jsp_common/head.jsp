<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="${pageContext.request.contextPath}/">
<link href="ui/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<%--<link rel="stylesheet" href="${pageContext.request.contextPath}/ui/css/style.css">--%>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<!--slider-->
<link href="ui/css/slider.css" rel="stylesheet" type="text/css" media="all"/>
<link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">
<script type="text/javascript" src="ui/js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="ui/js/jquery.nivo.slider.js"></script>
<script type="text/javascript" src="ui/js/log.js"></script>
<script type="text/javascript">
    $(window).load(function () {
        $('#slider').nivoSlider();
    });
</script>
