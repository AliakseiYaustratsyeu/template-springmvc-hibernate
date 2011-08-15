<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${not empty param.error}">
    <font color="red"> Login error. <br />
    Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
</c:if>
<c:if test="${not empty param.sessionexpired}">
    <font color="red"> Your session has been expired. Login again, please!</font>    
</c:if>

<c:url var="loginUrl" value="/j_spring_security_check" />
<form method="POST" action="${loginUrl}">
<table>
    <tr>
        <td align="right">Username</td>
        <td><input type="text" name="j_username" /></td>
    </tr>
    <tr>
        <td align="right">Password</td>
        <td><input type="password" name="j_password" /></td>
    </tr>
    <tr>
        <td align="right">Remember me</td>
        <td>
            <input id="_spring_security_remember_me" type="checkbox" name="_spring_security_remember_me" />
            <label for="_spring_security_remember_me" ><fmt:message key="login.rememberMe"/></label>
        </td>
    </tr>
    <tr>
        <td colspan="2" align="right"><input type="submit" value="Login" /> <input type="reset" value="Reset" />
        </td>
    </tr>
</table>
</form>