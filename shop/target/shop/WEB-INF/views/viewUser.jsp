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
<p><label>User Name</label>: ${user.username }</p>
<p><label>Password</label>: ${user.password }</p>
<p><label>Full Name</label>: ${user.fullName }</p>
<p><label>Address</label>: ${user.address }</p>
<p><label>Date of Birth</label>: ${user.dob }</p>
<p><label>Email</label>: ${user.email }</p>
<p><label>Identity Number</label>: ${user.identityNumber }</p>
<p><label>Genger</label>: ${user.gender }</p>
<p><label>Phone Number</label>: ${user.phoneNumber }</p>
<p><label>Role ID</label>: ${user.roleId }</p>

</form:form>

</body>
</html>