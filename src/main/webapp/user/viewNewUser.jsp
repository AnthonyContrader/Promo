<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>View New User</title>

<%@ include file="/css/header.jsp" %>
</head>

<body>
	
	<div class="container container-center">
		<h1 class="h3 mb-3 font-weight-normal">Inserisci New User</h1>
		<form action="/User/insertNewUser" method="post">
			<label for="username" class="sr-only">Username</label> 
			<input type="text" name="username" id="username" class="form-control" placeholder="Username" required autofocus /> 
			<label for="password" class="sr-only">Password</label> 
			<input type="password" name="password" id="password" class="form-control" placeholder="Password" required> 
			<label for="usertype" class="sr-only">Usertype</label> 
			<input type="text" name="usertype" id="usertype" class="form-control" placeholder="Usertype" required>
			<label for="barcode" class="sr-only">Barcode</label> 
			<input type="number" min="1" name="barcode" id="barcode" class="form-control" placeholder="Barcode" required>
			<label for="scode" class="sr-only">Scode</label> 
			<input type="text" name="scode" id="scode" class="form-control" placeholder="Scode" required>
			
			<button class="btn btn-lg btn-primary btn-block" type="submit">Inserisci</button>
			
		</form>
	</div>
	
<%@ include file="/js/scripts.jsp" %>
</body>
</html>