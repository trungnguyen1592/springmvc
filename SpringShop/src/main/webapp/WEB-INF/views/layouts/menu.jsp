<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<div class="section-items nav-sections-items">
	<div class="section-item-content">
		<nav class="navigation">
			<ul>
			<c:forEach items="${categories }" var="category">
				<li>
					<a href="<c:url value="/detail-category/${category.category_id }" />">${category.name }</a>
				</li>
			</c:forEach>
			</ul>
		</nav>
	</div>
</div>