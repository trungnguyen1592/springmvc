<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<div class="panel wrapper">
	<div class="panel header">
		<ul>
			<li class="airplane hidden-mobile"><a href="">Free Express Shipping Over $99</a></li>
			<li class="freereturn"><a href="#">Hassle Free Returns</a></li>
			<li class="auowned"><a href="#">Australian Owned</a></li>
			<li class="tel"><a href="#">1300 818 849</a></li>
			<li class="feefo"><img class="img-responsive" src="<c:url value='/static/image/feefo.png'/>" width="150" height="38"></li>
		</ul>

		<ul class="header links">
			<security:authorize access="isAuthenticated()">
				<security:authentication property="principal" var="user"/>
				<li class="greet welcome"><span>Welcome : ${user.username }
				, <a class="logout" href='<c:url value="/logout" />'> Logout</a></span></li>
			</security:authorize>
			<li class="authorization-link"><a href="<c:url value='/login'/>"> Login </a> / <a href="<c:url value='/register'/>">Join</a></li>
		</ul>
		<div class="minicart-wrapper">
			<a class="action showcart" href="<c:url value='/view-cart'/>"></a>
		</div>
	</div>
</div>
<div class="header content">
	<a class="logo" href="<c:url value="/" />" title="BStore">
        <img src="<c:url value='/static/image/logo.png'/>" alt="BStore" width="280" height="68">
    </a>
	<div class="block block-search">
		<div class="block block-content">
			<form id="search_mini_form" action="" method="get">
				<div class="searchbox">
					<input class="algolia-search-input" id="search" type="text" name="q" class="" placeholder="Search entire store...">
					<span id="algolia-glass" class="magnifying-glass" width="24" height="24"></span>
				</div>
			</form>
		</div>
	</div>
</div>
