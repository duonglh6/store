
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<head>
<meta charset="utf-8">
<title>jQuery UI Datepicker functionality</title>
<link
	href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<!-- Javascript -->
<script>
	$(function() {
		$("#datepicker-3").datepicker({
			appendText : "(yy-mm-dd)",
			dateFormat : "yy-mm-dd",
		// 		$("#datepicker-11").datepicker({
		// 			showWeek : true,
		// 			yearSuffix : "-CE",
		// 			showAnim : "explode"
		});
	});
</script>
</head>
<body>
	<c:url var="formSubmit" value="/update-user/${user.userId}" />
	<form:form id="formEdit" modelAttribute="user" action="${formSubmit}"
		method="POST">

		<h2>UPDATE USER</h2>
		<table>
			<form:hidden path="userId" />
			<tr>
				<td>UerName:</td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Full Name:</td>
				<td><form:input path="fullName" /></td>
			</tr>
			<tr>
				<td>Identity Number:</td>
				<td><form:input path="identityNumber" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" /></td>

			</tr>
			<tr>
				<td>Phone Number:</td>
				<td><form:input path="phoneNumber" /></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td>Enter Date:</td>
				<td><form:input path="date" id="datepicker-3" /></td>
			</tr>
			<tr>
				<td>Select Role:</td>
				<td><form:select path="roleId" id="roleId">
<%-- 						<form:option value="NONE" label="--- Select Role ---" /> --%>
						<form:options items="${user.listRole}" />
					</form:select></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><form:radiobutton path="gender" value="1" />Male <form:radiobutton
						path="gender" value="0" />Female <form:radiobutton path="gender"
						value="2" />Other</td>
			</tr>

		</table>
		<input type="submit" value="Submit">

	</form:form>
