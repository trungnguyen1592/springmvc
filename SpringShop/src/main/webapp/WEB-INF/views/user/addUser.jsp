<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<p>add user</p>
<c:url value="/admin/add-user" var="url" />
<form:form modelAttribute="user" method="post" action="${url }">
	<form:hidden path="id"/>
	<p>Username : </p><form:input path="name"/>
	<form:errors path="name"></form:errors>
	<p>Phone : </p><form:input path="phone"/>
	<form:errors path="phone"></form:errors>
	<button type="submit">Submit</button>
</form:form>	
