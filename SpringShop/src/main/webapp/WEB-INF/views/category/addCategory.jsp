<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<p>add category</p>
<c:url value="/add-category" var="url" />
<form:form modelAttribute="category" method="post" action="${url }" enctype="multipart/form-data">
	<form:hidden path="category_id"/>
	<p>Name : </p><form:input path="name"/>
	<form:errors path="name"></form:errors>
	<form:input type="file" path="file"/>
	<button type="submit">Submit</button>
</form:form>	
