<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="user">
<h2>Thông tin người dùng</h2>
<p><label>Name</label>: ${user.name }</p>
<p><label>ID</label>: ${user.id }</p>
<p><label>Email</label>: ${user.email }</p>


</form:form>

</body>
</html>