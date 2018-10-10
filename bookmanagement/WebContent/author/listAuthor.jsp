<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.author {
	width: 50%;
}

table {
	text-align: center;
}

th {
	text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AuthorController" method="GET">
	<input type="hidden" name="command" value="ADD">
		<%@include file="../header/header.jsp"%>


		<h1>DANH SÁCH TÁC GIẢ</h1>
		<table border="1" width="50%">
			<tr>
				<th><label>ID</label></th>
				<th><label>NAME</label></th>
				<th><label>DATE OF BIRTH</label></th>
			</tr>
			<c:forEach var="listAuthor" items="${listAuthor}">
			<c:url value="AuthorController" var="deleteLink">
			<c:param name="command" value="DELETE"></c:param>
			<c:param name="authorId" value="${listAuthor.id}"></c:param>
			</c:url>
				<tr>
					<td>${listAuthor.id}</td>
					<td>${listAuthor.name}</td>
					<td>${listAuthor.dob}</td>
					<td><a href="${deleteLink}" >DELETE</a></td>
				</tr>


			</c:forEach>




		</table class="author">
		<h3>ADD New Author</h3>
		<table>
			<tr>
				<td><input type="submit" value="Submit"></td>
				<td><input type="text" name="authorName" placeholder="insert name of author"></td>
				<td><input type="text" name="date" placeholder="insert date of birth &quot;yyyy-MM-dd&quot;"></td>

			</tr>


		</table>
	</form>
</body>
</html>