<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="user" class="com.hp.model.UserModel" scope="session" />
	<%
		if (user.getName() == null) {  response.sendRedirect("index.jsp");
		}
	%>
	<style>
div {
	background-color: green;
}

div a {
	text-decoration: none;
	color: white;
	font-size: 20px;
	padding: 15px;
	display: inline-block;
}

ul {
	display: inline;
	margin: 0;
	padding: 0;
}

ul li {
	display: inline-block;
}

ul li:hover {
	background: #555;
}

ul li:hover ul {
	display: block;
}

ul li ul {
	position: absolute;
	width: 200px;
	display: none;
}

ul li ul li {
	background: #555;
	display: block;
}

ul li ul li a {
	display: block !important;
}

ul li ul li:hover {
	background: #666;
}
</style>
</head>
<body>

	<div>
		<a href="#">BOOK STORE</a>
		<ul>
			<li><a href="#">REPORT</a>
				<ul>
					<li><a href="BookStoreController?command=TOP_REVENUE_BY_AUTHOR">TOP_REVENUE_BY_AUTHOR</a></li>
					<li><a href="BookStoreController?command=TOP_REVENUE_BY_CATEGORY">TOP_REVENUE_BY_CATEGORY</a></li>
					<li><a href="BookStoreController">SHOW ALL</a></li>
				</ul></li>
			<li><a href="#">MANAGEMENT</a>
				<ul>
					<li><a href="BookController">BOOKs</a></li>
					<li><a href="CategoryController">CATEGORYs</a></li>
					<li><a href="AuthorController">AUTHORs</a></li>
				</ul></li>
		</ul>
	</div>

</body>
</html>