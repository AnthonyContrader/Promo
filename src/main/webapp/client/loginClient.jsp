<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>


<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>PROMO LOGIN PAGE CLIENT</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/style.css" rel="stylesheet">

</head>

<body>
	<div class="container container-center">
		<h1 class="h3 mb-3 font-weight-normal">Promo: LOGIN CLIENT</h1>
		<form action="/Client/login" method="post">
			<label for="username" class="sr-only">Username</label> 
			<input type="text" name="username" id="username" class="form-control" placeholder="Username" required autofocus /> 
			<label for="password" class="sr-only">Password</label> 
			<input type="password" name="password" id="password" class="form-control" placeholder="Password" required> 
			
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign	in</button>
		</form>
	</div>
	
<%@ include file="/js/scripts.jsp" %>
</body>
</html>