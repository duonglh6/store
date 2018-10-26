
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


	<h2>List User</h2>
	<table border="1">
		<tr>
			<th><label>User ID</label></th>
			<th><label>Full Name</label></th>
			<th><label>Username</label></th>
			<th><label>Gender</label></th>
			<th><label>Identity Number</label></th>
			<th><label>Email</label></th>
			<th><label>Date of Birth</label></th>
			<th><label>Address</label></th>
			<th><label>Phone Number</label></th>
			<th><label>Role ID</label></th>
			<th><label>Options</label></th>

		</tr>

		<c:forEach var="listUser" items="${listUser}">
			<c:url var="deleteLink" value="/delete-user/${listUser.userId}"></c:url>
			<c:url var="updateLink" value="/update-user/${listUser.userId}"></c:url>
			<tr>
				<td>${listUser.userId}</td>
				<td>${listUser.fullName}</td>
				<td>${listUser.username}</td>
				<c:if test="${listUser.gender==1}">
					<td>Male</td>
				</c:if>
				<c:if test="${listUser.gender==0}">
					<td>Female</td>
				</c:if>
				<c:if test="${listUser.gender==2}">
					<td>Other</td>
				</c:if>
				<td>${listUser.identityNumber}</td>
				<td>${listUser.email}</td>
				<td>${listUser.date}</td>
				<td>${listUser.address}</td>
				<td>${listUser.phoneNumber}</td>
				<td>${listUser.roleId}</td>
				<td><a href="${updateLink}">Update</a> | <a
					href="${deleteLink}">Delete</a></td>
			</tr>


		</c:forEach>
	</table>
