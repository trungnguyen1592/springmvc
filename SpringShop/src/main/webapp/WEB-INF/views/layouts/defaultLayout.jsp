<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HomePage</title>

<spring:url value="/static/css/style.css" var="mainCss" />
<spring:url value="/static/css/bootstrap.min.css" var="Bootstrap" />
<spring:url value="/static/js/main.js" var="Js" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>

<link href="${Bootstrap}" rel="stylesheet" type="text/css">
<link href="${mainCss}" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${Js}"></script>
<body>

	<header class="page-header">
		<tiles:insertAttribute name="header" />
	</header>
	
	<div class="sections nav-sections">
		<tiles:insertAttribute name="menu" />
	</div>
	
	<main id="maincontent" class="page-main">
		<tiles:insertAttribute name="body" />
	</main>
	
	<footer id="footer" class="page-footer">
		<tiles:insertAttribute name="footer" />
	</footer>


</body>
</html>