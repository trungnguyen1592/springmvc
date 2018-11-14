<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table>
	<tr>
		<th>ID</th>
		<th>Category</th>
		<th>Name</th>
		<th>Price</th>
		<th>Select</th>
	</tr>

	<c:forEach items="${products }" var="product">
		<tr>
			<td>${product.id }</td>
			<td>${product.categoryDTO.name }</td>
			<td>${product.name }</td>
			<td>${product.price }</td>
			<td><a href='<c:url value="/detail-product/${product.id }" />'>Detail</a>
				<a href='<c:url value="/edit-product/${product.id }" />'>Edit</a> 
				<a href='<c:url value="/delete-product/${product.id }" />'>Delete</a>
				<a href='<c:url value="/add-to-cart/${product.id }" />'>Add to cart</a>
			</td>
		</tr>
	</c:forEach>
</table>
