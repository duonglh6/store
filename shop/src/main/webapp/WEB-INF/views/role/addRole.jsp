<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url value="/add-role" var="formSubmit" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Form add Role</p>
	<form:form modelAttribute="role" method="POST" action="${formSubmit}">

<%-- 		<form:input path="roleId" /> --%>
		<form:input path="roleName" />
		<button type="submit">Submit</button>




	</form:form>
</body>
</html>