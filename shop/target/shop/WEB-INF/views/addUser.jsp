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
<form:form modelAttribute="user" method="POST" action="view-user">
<p><label>User Name</label></p>
<p><form:input path="username" /></p>
<p><label>Password</label></p>
<p><form:input path="password" /></p>
<p><label>Full Name</label></p>
<p><form:input path="fullName" /></p>
<p><label>Address</label></p>
<p><form:input path="address" /></p>
<p><label>Date of Birth</label></p>
<p><form:input placeholder="insert date of birth &quot;yyyy-MM-dd&quot;" path="dob" /></p>
<p><label>Email</label></p>
<p><form:input path="email" /></p>
<p><label>Identity Number</label></p>
<p><form:input path="identityNumber" /></p>
<p><label>Genger</label></p>
<p><form:input path="gender" /></p>
<p><label>Phone Number</label></p>
<p><form:input path="phoneNumber" /></p>


<%-- <form:select path="roleId"> --%>
<%-- <form:option value="none" label="Select Role"></form:option> --%>
<%-- <form:options items="${user.getAllRole}"/> --%>


<%-- </form:select> --%>
<button type="submit">Submit</button>


</form:form>
</body>
</html>