<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
    <tiles:useAttribute id="title" name="title" classname="java.lang.String"/>
    <title><fmt:message key="${title}" /></title>
    
    <link rel="stylesheet" type="text/css" media="all" href="${resourceUrl}/css/main.css" />
    <link rel="stylesheet" type="text/css" media="all" href="${resourceUrl}/css/menu.css" />
    <link rel="stylesheet" type="text/css" media="all" href="${resourceUrl}/css/header.css" />
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