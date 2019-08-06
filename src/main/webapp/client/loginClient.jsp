<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>


<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>PROMO LOGIN CLIENT</title>

<%@ include file="/css/header.jsp" %>

<style>

	body {
		background: url('/img/sfondo_template_2.jpg');
	}
	
</style>

</head>

<body>
	<div class="container-login ml-4 mt-4">
		<h1 class="h3 mb-3 font-weight-normal text-white">Promo: LOGIN CLIENT</h1>
		<form action="/Client/login" method="post">
			<label for="username" class="sr-only">Username</label> 
			<input type="text" name="username" id="username" class="form-control mb-2" placeholder="Username" required autofocus /> 
			<label for="password" class="sr-only">Password</label> 
			<input type="text" name="password" id="password" class="form-control" placeholder="Password" required> 
			
			<div class="container-submit-login my-3">
				<button class="btn btn-lg btn-outline-danger" type="submit">Sign in</button>
			</div>
			<div class="d-flex justify-content-between">
				<button onclick="goBack()" type="button" class="btn" title="Indietro">
					<i class="fas fa-arrow-left fa-2x text-white"></i>
				</button>
			</div>
		</form>
	</div>
	
	<div class="container-index">
		<div class="title-index">
			<h1 class="text-danger">PROMO</h1>
		</div>
	</div>
	
<%@ include file="/js/scripts.jsp" %>
</body>
</html>