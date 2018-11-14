<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="breadcrumbs">
	<ul class="items">
		<li class="item home"><a href='<c:url value="/" />' title="Go to Home Page"> Home </a></li>
		<li class="item category10"><strong>${category.name }</strong></li>
	</ul>
</div>



<div class="page-title-wrapper">
	<h1 class="page-title" id="page-title-heading">
		<span class="base">${category.name }</span>
	</h1>
</div>

<table>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Price</th>
		<th>Select</th>
	</tr>

	<c:forEach items="${products }" var="product">
		<tr>
			<td>${product.id }</td>
			<td>${product.name }</td>
			<td>${product.price }</td>
			<td><a href='<c:url value="/detail-product/${product.id }" />'>Detail</a>
				<a href='<c:url value="/edit-product/${product.id }" />'>Edit</a> <a
				href='<c:url value="/delete-product/${product.id }" />'>Delete</a> <a
				href='<c:url value="/add-to-cart/${product.id }" />'>Add to cart</a>
			</td>
		</tr>
	</c:forEach>
</table>
