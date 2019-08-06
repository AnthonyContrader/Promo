<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Register User</title>

<%@ include file="/css/header.jsp" %>

<style>

	body {
		background: url('/img/sfondo_template_2.jpg');
	}
	
</style>

</head>

<body>
	
	<div class="container-login ml-4 mt-4">
		<h1 class="h3 mb-3 font-weight-normal text-white">Promo: Area Riservata->Registrati</h1>
		<form action="/User/registerNewUser" method="post">
			<label for="username" class="sr-only">Username</label> 
			<input type="text" name="username" id="username" class="form-control mb-2" placeholder="Username" required autofocus /> 
			<label for="password" class="sr-only">Password</label> 
			<input type="text" name="password" id="password" class="form-control mb-2" placeholder="Password" required> 
			<label for="usertype" class="sr-only">Usertype</label> 
			<input type="text" name="usertype" id="usertype" class="form-control mb-2" placeholder="Usertype" required>
			<label for="barcode" class="sr-only">Barcode</label> 
			<input type="number" min="1" name="barcode" id="barcode" class="form-control mb-2" placeholder="Barcode" required>
			<label for="scode" class="sr-only">Scode</label> 
			<input type="text" name="scode" id="scode" class="form-control mb-2" placeholder="Scode" required>
			
			<div class="container-submit-login my-3">
				<button class="btn btn-lg btn-outline-danger" type="submit">Registrati</button>
			</div>
			<a href="/User/areariservata/" class="text-white">Login</a>
		</form>
	</div>
	
	<div class="container-index">
		<div class="client-login-index">
			<a href="/Client/viewloginClient/" class="text-dark font-weight-bold">Login</a>
		</div>
		<div class="client-freeEnter-index mb-4">
			 <a href="/Client/freeEnter" class="text-danger font-weight-bold">Entra</a>
		</div>
		<div class="title-index">
			<h1 class="text-danger">PROMO</h1>
		</div>
	</div>
	
<%@ include file="/js/scripts.jsp" %>
</body>
</html>