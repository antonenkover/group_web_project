<!doctype html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>
<base href="${pageContext.request.contextPath}/">
<html>
<div class="content-middle">
    <div class="wrap">
        <div class="section group group1">
            <div class="section group grid2">
                <div class="listview_1_of_2 images_1_of_2">
                    <div class="listimg listimg_2_of_1">
                        <img src="ui/images/chart.png">
                    </div>
                    <div class="text list_2_of_1">
                        <h3><fmt:message key="middlethumbnail1"/><br></h3>
                        <h4><fmt:message key="middlecaption1"/><br></h4>
                        <p><fmt:message key="middletext1"/><br></p>
                    </div>
                </div>
                <div class="listview_1_of_2 images_1_of_2">
                    <div class="listimg listimg_2_of_1">
                        <img src="ui/images/hand.png">
                    </div>
                    <div class="text list_2_of_1">
                        <h3><fmt:message key="middlethumbnail2"/><br></h3>
                        <h4><fmt:message key="middlecaption2"/><br></h4>
                        <p><fmt:message key="middletext2"/><br></p>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="section group grid2">
                <div class="listview_1_of_2 images_1_of_2">
                    <div class="listimg listimg_2_of_1">
                        <img src="ui/images/bulb.png">
                    </div>
                    <div class="text list_2_of_1 ">
                        <h3><fmt:message key="middlethumbnail3"/><br></h3>
                        <h4><fmt:message key="middlecaption3"/><br></h4>
                        <p><fmt:message key="middletext3"/><br></p>
                    </div>
                </div>
                <div class="listview_1_of_2 images_1_of_2">
                    <div class="listimg listimg_2_of_1">
                        <img src="ui/images/date.png">
                    </div>
                    <div class="text list_2_of_1">
                        <h3><fmt:message key="middlethumbnail4"/><br></h3>
                        <h4><fmt:message key="middlecaption4"/><br></h4>
                        <p><fmt:message key="middletext4"/><br></p>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
</html>