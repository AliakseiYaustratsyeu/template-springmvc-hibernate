<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<tiles:useAttribute id="title" name="title" classname="java.lang.String"/>

<html>
<head>
    <title><fmt:message key="${title}" /></title>
    <c:url var="mainCssUrl" value='/css/main.css'/>
    <link rel="stylesheet" type="text/css" media="all" href="${mainCssUrl}" />
    <c:url var="menuCssUrl" value='/css/menu.css'/>
    <link rel="stylesheet" type="text/css" media="all" href="${menuCssUrl}" />
    <c:url var="headerCssUrl" value='/css/header.css'/>
    <link rel="stylesheet" type="text/css" media="all" href="${headerCssUrl}" />
</head>
<body>
    <div id="container">
        <div id="header">
            <tiles:insertAttribute name="header" />
        </div>
        <div id="menu">
            <tiles:insertAttribute name="menu" />
        </div>
        <div id="body">
            <tiles:insertAttribute name="body" />
        </div>
        <div id="footer">
            <tiles:insertAttribute name="footer" />
        </div>
    </div>
</body>
</html>