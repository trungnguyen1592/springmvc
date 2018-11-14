<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<p>add product</p>
<c:url value="/add-product" var="url" />
<form:form modelAttribute="product" method="post" action="${url }" enctype="multipart/form-data">
	<form:hidden path="id"/>
	<p>Name : </p><form:input path="name"/>
	<form:errors path="name"></form:errors>
	
	<p>Category : </p>
	
	<form:select path="category_id">
		<c:forEach items="${categories }" var="category">
			<form:option value="${category.category_id }">${category.name }</form:option>
		</c:forEach>
	</form:select>
	
	<form:errors path="category_id"></form:errors>
	
	
	<p>Price : </p><form:input path="price"/>
	<form:errors path="price"></form:errors>
	<form:input type="file" path="file"/>
	<button type="submit">Submit</button>
</form:form>	
