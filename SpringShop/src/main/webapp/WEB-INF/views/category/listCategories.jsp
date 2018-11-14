<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table>
	<tr>
		<th>Category_ID</th>
		<th>Name</th>
		<th>Select</th>
	</tr>

	<c:forEach items="${categories }" var="category">
		<tr>
			<td>${category.category_id }</td>
			<td>${category.name }</td>
			<td><a href='<c:url value="/admin/detail-category/${category.category_id }" />'>Detail</a>
				<a href='<c:url value="/edit-category/${category.category_id }" />'>Edit</a> 
				<a href='<c:url value="/admin/delete-category/${category.category_id }" />'>Delete</a>
			</td>
		</tr>
	</c:forEach>
</table>
