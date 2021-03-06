<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
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

<h2>HTML Table</h2>

<table>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Revenue</th>
  </tr>
  <c:forEach items="${list}" var="item">
    <tr>
    <td>${item.id}</td>
    <td>${item.name}</td>
    <td>${item.revenue}</td>
  </tr>
  </c:forEach>

 
</table>

</body>
</html>
