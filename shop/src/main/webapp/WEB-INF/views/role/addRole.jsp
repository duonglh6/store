
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url value="/add-role" var="formSubmit" />

	<p>Form add Role</p>
	<form:form modelAttribute="role" method="POST" action="${formSubmit}">

<%-- 		<form:input path="roleId" /> --%>
		<form:input path="roleName" />
		<button type="submit">Submit</button>
	</form:form>
