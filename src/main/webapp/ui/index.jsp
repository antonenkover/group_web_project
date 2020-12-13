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
<c:import url="jsp_common/header_index.jsp"/>
<!------ End Header ----------------------->

<!------ Slider ----------------->
<c:import url="jsp_common/slider.jsp"/>
<!------End Slider ------------------------>


<div class="main">
    <!------ Main content ------------>
    <c:import url="jsp_common/content_top.jsp"/>
    <c:import url="jsp_common/content_middle.jsp"/>
    <c:import url="jsp_common/content_map.jsp"/>
    <!------ Main content end ----------------->
</div>
<!------ Footer ------------------->
<c:import url="jsp_common/footer.jsp"/>
<!------ Footer end ------------------------>
</body>
</html>



