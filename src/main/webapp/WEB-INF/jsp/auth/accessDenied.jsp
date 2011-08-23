<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h1>Access Denied</h1>
<p>
    Access to the specified resource has been denied for the following reason: 
    <strong>${errorDetails}</strong>. 
    <c:url var="mainPageUrl" value='/welcome.do'/>
    <p><a href="${mainPageUrl}">Go to the main page</a>
</p>
<em>Error Details (for Support Purposes only):</em><br />
<blockquote>
    <pre>${errorTrace}</pre>
</blockquote>
