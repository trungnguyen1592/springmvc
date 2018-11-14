<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="content">
<div class="page-title-wrapper">
	<h1>
		<span>Login Or Join</span>
	</h1>
</div>


<div class="column main login">
	<div class="login-container">
		<div class="block block-new-customer">
			<div class="block-title">
				<strong id="block-new-customer-heading">New Customers</strong>
			</div>
			<div class="block-content">
				<p>By creating an account with our store, you will be able to
					move through the checkout process faster, store multiple shipping
					addresses, view and track your orders in your account and more.</p>
				<div class="actions-toolbar">
					<div class="primary">
						<a href="/create/" class="action create primary"><span>Create
								Account</span></a>
					</div>
				</div>
			</div>
		</div>
		<div class="block block-customer-login">
			<div class="block-title">
				<strong id="block-customer-login-heading">Registered Customers</strong>
			</div>
			<div class="block-content">
				<c:url value="/login" var="url" />
				<form class="form form-login" method="post" action="${url }">
					<fieldset class="fieldset login">
						<div class="field note">If you have an account with us, please log in.</div>
						<div class="field username required">
							<label class="label"><span>Username</span></label>
							<div class="control">
								<input name="username" type="text" placeholder="Username">
							</div>
						</div>
						<div class="field password required">
							<label for="pass" class="label"><span>Password</span></label>
							<div class="control">
								<input name="password" type="password" placeholder="Password">
							</div>
						</div>
						<div class="actions-toolbar">
							<div class="primary">
								<button type="submit" class="action login primary" name="send" id="send2">
									<span>Login</span>
								</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<div class="login_page_image">
		<img alt="" width="750" height="500"
			src="<c:url value='/static/image/login-image.png'/>">
	</div>
</div>
</div>

