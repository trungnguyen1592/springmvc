<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HelloWorld</title>
<link href="<c:url value='/static/css/style.css'/>">
<script type="text/javascript" src="<c:url value='/static/js/main.js'  />"></script>
</head>
<body>
<p>add user</p>
<c:url value="/add-user" var="url" />
<form:form modelAttribute="user" method="post" action="${url }">
	<form:hidden path="id"/>
	<p>Username : </p><form:input path="name"/>
	<form:errors path="name"></form:errors>
	<p>password : </p><form:password path="password"/>
	<form:errors path="password"></form:errors>
	<p>Favourities</p><form:checkbox path="favourities" value="movie" label="movie" />
	<form:checkbox path="favourities" value="music" label="music" />
	<form:checkbox path="favourities" value="Code" label="coding" />
	<p>Gender</p>
	<form:select path="gender">
		<form:option value="female">Female</form:option>
		<form:option value="male">Male</form:option>
	</form:select>	
	<p>About</p>
	<form:textarea path="about"/><br/>
	<form:radiobutton path="acceptAgreement" value="true" label="Dong y dieu khoan su dung" /><br/><br/><br/>
	<button type="submit">Submit</button>
</form:form>	
</body>
</html>
