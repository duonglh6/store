<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
	<html>
	
	<body>
	<%@include file = "../header/header.jsp" %>
	<form action="BookController" method="get">
	<h3>ADD NEW BOOK FORM</h3>
		<input type="hidden" name="command" value="ADD"/>
		
		<table>
		<tr>
		<td><label>Book Name</label></td>
		<td><input type="text" name="bookName" placeholder="Book Name"/></td>
		</tr>
		<tr>
		<td><label>Sold Number</label></td>
		<td><input type="text" name="soldNumber"/></td>
		</tr>
		<tr>
		<td><label>Price ($)</label></td>
		<td><input type="text" name="price"/></td>
		</tr>
		<tr>
		<td><label>Category</label></td>
		<td>
		<select name="category">
		<c:forEach var="listCategory" items="${listCategory}">
		<option value="${listCategory.id}">${listCategory.name}</option>	
		</c:forEach>	
		</select>
		</td>
		</tr>
		<tr>
		<td><label>Author</label></td>
	
		<td>
		<c:forEach var="listAuthor" items="${listAuthor}">
		<input type="checkbox" name="author" value="${listAuthor.id}">${listAuthor.name}	
		</c:forEach>	
		
		<td>
		
		</tr>
		
		
		</table>
		<input type="submit" value="Sumit">
	
	
	
	
	</form>
	
	
	
	
	
	</body>
	
	
	
	</html>