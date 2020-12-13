<!doctype html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>
<html>
<div class="content-bottom">
    <div class="map">
        <iframe src="<fmt:message key="map.location"/><br>" width="100%" height="300" frameborder="0" style="border:0;"
                allowfullscreen=""></iframe>
        <br>
    </div>
</div>
</html>