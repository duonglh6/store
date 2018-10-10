<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
h1{text-align: center;
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
</head>
<body>
<%@include file = "../header/header.jsp" %>
<h1>DANH SÁCH SÁCH</h1>

<table>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>SOLD_NUMBER</th>
    <th>PRICE</th>
  </tr>
  <c:url var="addNewLink" value="BookController">
  <c:param name="command" value="NEW"></c:param>
  
  </c:url>
  <c:forEach items="${showAllBook}" var="item">
  <c:url var="updateLink" value="BookController">
  <c:param name="bookId" value="${item.id}"></c:param>
  <c:param name="command" value="LOAD"></c:param>
  
  
  
  </c:url>
  <c:url var="deleteLink" value="BookController">
  <c:param name="bookId" value="${item.id}"></c:param>
  <c:param name="command" value="DELETE"></c:param>
  </c:url>
    <tr>
    <td>${item.id}</td>
    <td>${item.name}</td>
    <td>${item.soldNumber}</td>
    <td>${item.price}</td>
    <td>
    <a href="${updateLink}">Update</a> 
    |
    <a href="${deleteLink}">Delete</a>
  </tr>
  </c:forEach>
  
  <tr>
  <td>
  <a href="${addNewLink}">Add New Book</a>
  </td>
  </tr>

 
</table>
</body>
</html>