
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div style="margin-left: 600px">
<c:url value="/add-role" var="formSubmit" />

	<p>Form add Role</p>
	<form:form modelAttribute="role" method="POST" action="${formSubmit}">

		<p>description</p><form:input path="description" /><br></br>
		<p>name</p><form:input path="name" />
		<button type="submit">Submit</button>
	</form:form>
</div>