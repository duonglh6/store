<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="formSubmit" value="/add-user" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form id="formEdit" modelAttribute="user" action="${formSubmit" method="POST">
	UerName:	 <form:input path="username" />
					<br>
					<br>
		<form:input path="email" />
					<br>
					<br>
		<form:input path="fullName" />
					<br>
					<br>
		<form:input path="identityNumber" />
					<br>
					<br>
		<form:input path="password" />
					<br>
					<br>
		<form:input path="phoneNumber" />
		<br>
					<br>
		<form:input path="address" />
					<br>
					<br>

		<form:select path="roleId" id="roleId">
			<form:option value="NONE" label="--- Chọn Vai Trò ---" />
			<form:options items="${model.listRole}" />
		</form:select>

       <input type="submit" value="Submit">

	</form:form>
</body>
</html>