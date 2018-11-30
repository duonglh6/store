<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<c:url var="formSubmit" value="/add-user" />
	<form:form id="formEdit" modelAttribute="model" action="${formSubmit}"
		method="POST">
  <form:hidden path="id"/>
		<h2>ADD USER</h2>
		<table>
			<tr>
				<td>UerName:</td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Full Name:</td>
				<td><form:input path="fullname" /></td>
			</tr>
			
			<tr>
				<td>Password:</td>
				<td><form:password path="password"/></td>
				
			</tr>
			

		
			<tr>
			     <c:forEach var="item" items="${model.roleDto}">
			      <td><form:checkbox path="roles" value="${item.name}" />${item.name}</td>
			     </c:forEach>
			</tr>
<!-- 			<tr> -->
<!-- 				<td>Select Role:</td> -->
<%-- 				<td><form:select path="roleId" id="roleId"> --%>
<%-- 						<form:option value="NONE" label="--- Select Role ---" /> --%>
<%-- 						<form:options items="${user.listRole}" /> --%>
<%-- 					</form:select></td> --%>
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>Gender:</td> -->
<%-- 				<td><form:radiobutton path="gender" value="1"/>Male --%>
<%-- 				<form:radiobutton path="gender" value="0"/>Female --%>
<%-- 				<form:radiobutton path="gender" value="2"/>Other --%>
<!-- 				</td> -->
<!-- 			</tr> -->

		</table>
		
		<input type="submit" value="Submit">
<!-- 		<button type="button" class="btn  btn-raised bg-indigo waves-effect">INDIGO</button> -->

	</form:form>
