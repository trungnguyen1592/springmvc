<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content homepage">
	<div class="main-slider">
		<div>
			<img alt="" src="<c:url value='/static/image/homepage1.jpg'/>">
		</div>
		<div>
			<img alt="" src="<c:url value='/static/image/homepage2.jpg'/>">
		</div>
	</div>

	<div class="homepage_block">
		<div class="container">
			<div class="row">
				<c:forEach items="${categories }" var="category">
					<div class="item item-1 col-lg-4 col-md-4 col-sm-4 col-xs-12">
						<div>
							<img height="400" alt="" src="<c:url value='/files/${category.thumbnail }'/>">
							<a href="<c:url value="/detail-category/${category.category_id }" />">${category.name }</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>

	</div>


</div>