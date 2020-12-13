<!doctype html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>
<html>
<div class="content-top">
    <base href="${pageContext.request.contextPath}/">
    <div class="wrap">
        <div class="section group">
            <div class="col_1_of_3 span_1_of_3">
                <div class="thumb-pad2">
                    <div class="thumbnail">
                        <h4><fmt:message key="thumbnail1"/><br></h4>
                        <figure><img src="ui/images/pic.jpg" alt=""><em class="sp1"></em></figure>
                        <div class="caption">
                            <p><fmt:message key="caption1"/><br>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col_1_of_3 span_1_of_3">
                <div class="thumb-pad2">
                    <div class="thumbnail">
                        <h4><fmt:message key="thumbnail2"/><br></h4>
                        <figure><img src="ui/images/pic1.jpg" alt=""><em class="sp1"></em></figure>
                        <div class="caption">
                            <p>
                                <fmt:message key="caption2"/><br>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col_1_of_3 span_1_of_3">
                <div class="thumb-pad2">
                    <div class="thumbnail">
                        <h4>
                            <fmt:message key="thumbnail3"/><br>
                        </h4>
                        <figure><img src="ui/images/pic2.jpg" alt=""><em class="sp1"></em></figure>
                        <div class="caption">
                            <p>
                                <fmt:message key="caption3"/><br>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
</html>
