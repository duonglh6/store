
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	<h2>List Role</h2>
<a href="add-role">Add new Role</a><br>
<br>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Option</th>
		</tr>

		<c:forEach var="listRole" items="${listRole}">
			<c:url var="deleteLink" value="/delete-role">
				<c:param name="roleId" value="${listRole.roleId}"></c:param>
			</c:url>
			<c:url var="updateLink" value="/update-role">
				<c:param name="roleId" value="${listRole.roleId}"></c:param>
			</c:url>
			<tr>
				<td>${listRole.roleId}</td>
				<td>${listRole.roleName}</td>
				<td><a href="${updateLink}">Update</a>
				|
				<a href="${deleteLink}">Delete</a></td>
			</tr>


		</c:forEach>
	</table>
