<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>List User</h2>
<table border="1">
		<tr>
			<th>Role ID</th>
			<th>DOB</th>
			<th>Username</th>
			<th>Sex</th>
		</tr>

		<c:forEach var="listUser" items="${listUser}">
<%-- 			<c:url var="deleteLink" value="/delete-role"> --%>
<%-- 				<c:param name="roleId" value="${listRole.roleId}"></c:param> --%>
<%-- 			</c:url> --%>
<%-- 			<c:url var="updateLink" value="/update-role"> --%>
<%-- 				<c:param name="roleId" value="${listRole.roleId}"></c:param> --%>
<%-- 			</c:url> --%>
			<tr>
				<td>${listUser.roleId}</td>
				<td>${listUser.date}</td>
				<td>${listUser.username}</td>
				
				<c:if test="${listUser.gender == 1}">		<td>Nam</td>
				</c:if>
				<c:if test="${listUser.gender == 0}">
				<td>Nu</td>
				</c:if>
				<td><a  href='<c:url value="/edit-user/${listUser.userId}"/>'>Update</a>
<!-- 				| -->
<%-- 				<a href="${deleteLink}">Delete</a></td> --%>
			</tr>


		</c:forEach>
	</table>
</body>
</html>