<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	//
	<c:url value="hello" var="url" />
	<form:form modelAttribute="user" method="post" action="hello" enctype="multipart/form-data">

		<p><label>Name</label></p>
		<p><form:input path="name" /></p>
		<p style="color: red"><form:errors path="name"></form:errors>

		<p><label>ID</label></p>
		<p><form:input path="id" /></p>
		<p style="color: red"><form:errors path="id"></form:errors>
		<p><label>EMAIL</label></p>
		<p><form:input path="email" /></p>
		<p style="color: red"><form:errors path="email"></form:errors>
		<p><label>Avarta</label><form:input path="avatar" type="file"  /></p>

		<button type="submit">Submit</button>
	</form:form>
</body>
</html>