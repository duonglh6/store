<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file = "../header/header.jsp" %>
	TOP REVENUE BY CATEGORY
	<table border="1">
		<tr>
			<th>Category Name</th>
			<th>Revenue</th>
		</tr>
		<c:forEach var="tempCategory" items="${getRevenueByCategory}">
		<tr>
		<td>${tempCategory.name}</td>
		<td>${tempCategory.revenue}</td>
		</tr>
		</c:forEach>


	</table>
</body>
</html>