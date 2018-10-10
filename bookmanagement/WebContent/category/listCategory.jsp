<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
<title>Insert title here</title>
<style>
h1{
text-align: center;
font-family: Arial, sans-serif;
}
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
	<script type="text/javascript">
function conf()
{
var con=confirm("Do you want to submit for sure?");
}
</script>
</head>
<body>
<form action="CategoryController" method="get">
<input type="hidden" name="command" value="ADD">
	<%@include file="../header/header.jsp"%>
	<h1><b>DANH SÁCH THỂ LOẠI</b></h1>

	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<!--     <th>SOLD_NUMBER</th> -->
			<!--     <th>PRICE</th> -->
		</tr>
		<c:forEach var="listCategory" items="${listCategory}">
			<c:url value="CategoryController" var="deleteLink">
				<c:param name="command" value="DELETE"></c:param>
				<c:param name="categoryId" value="${listCategory.id}"></c:param>
			</c:url>
			<tr>
				<td>${listCategory.id}</td>
				<td>${listCategory.name}</td>
				<td><a href="${deleteLink}" onclick="conf()"><img width="28" height="28" alt="DELETE" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAsk1eQQiFBePfK1D5zdHvwN1pcXusTPQnp0xbXLytMOE9rEDs"></a></td>


			</tr>



		</c:forEach>

	</table>
	<h3>ADD NEW CATEGORY</h3>
	<table>
		<tr>
			<td><label>CATEGORY NAME: <input name="categoryName" type="text"></label></td>
<!-- 			<td><input name="categoryName" type="text"></td> -->

		</tr>
		<tr>
			<td><input width="88" alt="Submit" type="image" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrQkzqpkqs2vJ_FQ0Y8O3PJ-40EA_EzZPKWdjWGPRfIlRpESMrRQ"></td>

		</tr>
	</table>
	</form>
</body>
</html>