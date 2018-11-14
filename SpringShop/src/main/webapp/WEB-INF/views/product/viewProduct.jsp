<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content">
	<div class="breadcrumbs">
		<ul class="items">
			<li class="item home"><a href='<c:url value="/" />'
				title="Go to Home Page"> Home </a></li>
			<li class="item category10"><strong>${product.name }</strong></li>
		</ul>
	</div>

	<div class="columns product">
		<div class="column main">
			<div class="container">
				<div class="product media">
					<img alt="" src="<c:url value='/files/${product.imageUrl }' />">
				</div>
				<div class="product-info-main">
					<div class="page-title-wrapper product">
						<h1 class="page-title" id="page-title-heading">
							<span class="base">${product.name }</span>
						</h1>
					</div>
					<div class="product-info-price">
						<span class="price">$${product.price } </span>
					</div>
					<div class="box-tocart">
						<a href='<c:url value="/add-to-cart/${product.id }" />'>Add to
							cart</a>
					</div>
					<div class="product-data">
						<h5 class="description">Description</h5>
						<p>These sandals feature the super stylish Mayari crossover
							straps in black Birko-Flor - this high quality synthetic material
							is exceptionally durable and easy to clean. The original
							Birkenstock cork-latex footbed supports your feet with its
							anatomical design, moulding to the shape of your feet over time
							for one of a kind comfort.</p>
						<p>
							<strong>Features</strong>
						</p>
						<ul>
							<li>Birko-flor synthetic upper</li>
							<li>Suede footbed lining</li>
							<li>Anatomically correct cork footbed for support</li>
							<li>Moulds to your feet over time</li>
							<li>Shock-absorbing EVA outsoles</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


