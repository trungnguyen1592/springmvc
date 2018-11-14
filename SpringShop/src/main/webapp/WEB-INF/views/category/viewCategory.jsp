<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content">

<div class="breadcrumbs">
	<ul class="items">
		<li class="item home"><a href='<c:url value="/" />'
			title="Go to Home Page"> Home </a></li>
		<li class="item category10"><strong>${category.name }</strong></li>
	</ul>
</div>

<div class="page-title-wrapper">
	<h1 class="page-title" id="page-title-heading">
		<span class="base">${category.name }</span>
	</h1>
</div>

<div class="columns category">
	<div class="column main">
		<div id="amasty-shopby-product-list">
			<div class="products wrapper grid products-grid">
				<ol class="products list items product-items">
					<c:forEach items="${products }" var="product">
						<li class="item product product-item">
							<div class="product-item-info">
								<a href="<c:url value="/detail-product/${product.id }" />" class="product photo product-item-photo"> <span
									class="product-image-container"> <span
										class="product-image-wrapper"> <img width="230"
											height="230" class="product-image-photo" alt=""
											src="<c:url value='/files/${product.imageUrl }' />">
									</span>
								</span>
								</a>
								<div class="product details product-item-details">
									<strong class="product name product-item-name"> <a href="<c:url value="/detail-product/${product.id }" />"
										class="product-item-link" href="#"> ${product.name } </a>
									</strong>
									<div class="price-box price-final_price">
										<span class="price-container price-final_price tax"> <spanclass="price-wrapper ">
											$<span class="price">${product.price }</span></span> </span>
									</div>
									<div class="product-item-inner">
										<div class="actions-primary">
											<a href='<c:url value="/add-to-cart/${product.id }" />'>Add to cart</a>
										</div>
									</div>
								</div>
							</div>
						</li>
					</c:forEach>
				</ol>
			</div>
		</div>
	</div>

	<div class="sidebar sidebar-main">
		<div class="block filter" id="layered-filter-block">
			<div class="block-content filter-content">
				<div class="filter-options-item">
					<div class="filter-options-title">Category</div>
					<div class="filter-options-content">
						<ol class="items">
							<c:forEach items="${categories }" var="category">
								<li class="item"><a
									href="<c:url value="/detail-category/${category.category_id }" />">${category.name }</a>
								</li>
							</c:forEach>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

</div>