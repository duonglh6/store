
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:url var="update" value="/update-role"/>
<form:form modelAttribute="role" method="POST" action="${update}">
<h2>Update Role</h2>
<!-- <input type="hidden" <form:input path="roleId"/> > -->
<form:hidden path="roleId"/>
<form:input path="roleName"/>
<button type="submit">Submit</button>

</form:form>
