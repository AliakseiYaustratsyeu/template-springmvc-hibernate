<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Active Users</h1>
<ul>
    <c:forEach items="${activeUsers}" var="uinfo">
        <li>
            <strong>${uinfo.key.username}</strong> 
            / Last Active: <strong>${uinfo.value}</strong>
        </li>
    </c:forEach>
</ul>

<div>
    ${numUsers} user(s) are logged in!
</div>