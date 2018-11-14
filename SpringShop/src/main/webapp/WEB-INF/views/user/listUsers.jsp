<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table>
	<tr>
		<th>ID</th>
		<th>Username</th>
		<th>Phone</th>
		<th>Select</th>
	</tr>

	<c:forEach items="${users }" var="user">
		<tr>
			<td>${user.id }</td>
			<td>${user.name }</td>
			<td>${user.phone }</td>
			<td><a href='<c:url value="/admin/detail-user/${user.id }" />'>Detail</a>
				<a href='<c:url value="/admin/edit-user/${user.id }" />'>Edit</a> <a
				href='<c:url value="/admin/delete-user/${user.id }" />'>Delete</a></td>
		</tr>
	</c:forEach>
</table>
