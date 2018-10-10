<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header/header.jsp"%>
	<form action="BookController" method="GET">
		<h3>UPDATE BOOK FORM</h3>
		<input type="hidden" name="command" value="UPDATE"> <input
			type="hidden" name="bookId" value="${loadBookById.id}">
		<table>
			<tr>
				<td><label>Name</label></td>
				<td><input type="text" name="name" value="${loadBookById.name}">
				</td>
			</tr>
			<tr>
				<td><label>Price</label></td>
				<td><input type="text" name="price"
					value="${loadBookById.price}"></td>
			</tr>
			<tr>
				<td><label>Sold Number</label></td>
				<td><input type="text" name="soldNumber"
					value="${loadBookById.soldNumber}"></td>
			</tr>
			<tr>
				<td><label>Category</label></td>
				<td><select name="categoryId">
						<option value="${loadBookById.category.id}" selected>${loadBookById.category.name}</option>
						<c:forEach var="list" items="${listCategory}">
							<c:if test="${loadBookById.category.id != list.id}">
								<option value="${list.id}">${list.name}</option>
							</c:if>
						</c:forEach>
				</select></td>
			</tr>	
			<tr>
				<td><label>Author</label></td>
			</tr>
			<c:forEach var="listAuthor" items="${listAuthor}">
				<tr>
					<td><input type="checkbox" name="authorId"
						value="${listAuthor.id}"> ${listAuthor.name}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>