<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="content">

	<div class="breadcrumbs">
		<ul class="items">
			<li class="item home"><a href='<c:url value="/" />'
				title="Go to Home Page"> Home </a></li>
			<li class="item category10"><strong>Cart</strong></li>
		</ul>
	</div>

	<div class="page-title-wrapper">
		<h1 class="page-title" id="page-title-heading">
			<span class="base">Shopping Cart</span>
		</h1>
	</div>

	<div class="columns cart">
		<div class="column main">
			<div class="cart-container">
				<div class="form form-cart">
					<div class="cart table-wrapper">
						<table class="cart items data table">
							<thead>
								<tr>
									<th class="col item" scope="col"><span>Item</span></th>
									<th class="col price" scope="col"><span>Price</span></th>
									<th class="col qty" scope="col"><span>Qty</span></th>
								</tr>
							</thead>
							<tbody class="cart item">
								<c:forEach items="${order.itemDTOs }" var="item">
									<tr class="item-info">
										<td class="col item"><a href="#"
											class="product-item-photo"> <span
												class="product-image-container" style="width: 140px;">
													<span class="product-image-wrapper"> 
														<img class="product-image-photo" src="<c:url value='/files/${item.productDTO.imageUrl }' />" width="140"
														height="140"></span>
											</span>
										</a>
											<div class="product-item-details">
												<strong class="product-item-name"> <a href="">${item.productDTO.name }</a>
												</strong>
											</div></td>

										<td class="col price" data-th="Price"><span
											class="price-including-tax"> <span class="cart-price ">
													<span class="price">$${item.productDTO.price }</span>
											</span>
										</span></td>
										<td class="col qty">
											<div class="field qty">
												<div class="control qty">${item.number }</div>
											</div>
										</td>
									</tr>
									<tr class="item-actions">
										<td colspan="100">
											<div class="actions-toolbar">
												<a class="action action-delete"
													href='<c:url value="/delete-cart/${item.productDTO.id }" />'><span>Delete</span></a>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<a class="order-button" href='<c:url value="/order" />'>Order</a>
</div>