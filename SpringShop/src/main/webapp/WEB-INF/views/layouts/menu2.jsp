<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<security:authorize access="isAuthenticated()">

<security:authentication property="principal" var="user"/>
Welcome : ${user.username }
<a href='<c:url value="/logout" />'>Logout</a><br />
</security:authorize>

<a href='<c:url value="/admin/add-user" />'>Add User</a>
<a href='<c:url value="/add-product" />'>Add Product</a>
<br />
<a href='<c:url value="/list-products" />'>List Product</a>
<a href='<c:url value="/admin/list-users" />'>List User</a>
<br />
<a href='<c:url value="/view-cart" />'>View Cart</a>
<br />
<a href='<c:url value="/list-categories" />'>List Categories</a>
<a href='<c:url value="/admin/add-category" />'>Add Category</a>