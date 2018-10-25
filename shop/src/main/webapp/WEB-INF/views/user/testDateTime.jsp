<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">
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
		 $( "#datepicker-3" ).datepicker({  
             appendText:"(yy-mm-dd)",  
             dateFormat:"yy-mm-dd",
// 		$("#datepicker-11").datepicker({
// 			showWeek : true,
// 			yearSuffix : "-CE",
// 			showAnim : "explode"
		});
	});
</script>
</head>
<body>
<c:url var="dateTime" value="/date-time" />
	<form:form method="POST" action="${dateTime}">
		<p>
<%-- 		<form:input path="dob" id="datepicker-3"/> --%>
			Enter Date: <input name="dateTime" type="text" id="datepicker-3">
		</p>
		<button type="submit">Submit</button>
	</form:form>
</body>
</html>

