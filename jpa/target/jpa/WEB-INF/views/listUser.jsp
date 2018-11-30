
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
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

<h2>List User</h2>

<table>
  <tr>
    <th>Name</th>
    <th>Email</th>
    <th>FullName</th>
  </tr>
  
  


  <c:forEach items="${model}" var="item">
     <tr>
    <td>${item.username}</td>
    <td>${item.email}</td>
    <td>${item.fullname}</td>
    <td><a href='<c:url value ="/edit/${item.id}"/>'>edit</a></td>
  </tr>
  </c:forEach>
  </table>
</body>
</html>