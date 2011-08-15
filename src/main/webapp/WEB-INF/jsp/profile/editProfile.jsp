<%@ include file="/common/taglibs.jsp"%>


<form:form commandName="user" action="/profile/save.do" method="post" id="userProfileForm">
<form:errors path="*" cssClass="error" />
    <table>
        <tr>
            <td>First Name:</td>
            <td><form:input path="firstName" /></td>
			<td><form:errors path="firstName" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><form:input path="lastName" /></td>
			<td><form:errors path="lastName" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><form:input path="email" /></td>
			<td><form:errors path="email" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><form:input path="phoneNumber" /></td>
			<td><form:errors path="phoneNumber" cssClass="error" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save Changes" /></td>
        </tr>
    </table>
</form:form>
