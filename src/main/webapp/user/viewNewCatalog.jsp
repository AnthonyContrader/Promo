<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Vedere gli Shop</title>

<%@ include file="/css/header.jsp" %>
</head>

<body>
	
	<div class="container container-center">
		<h1 class="h3 mb-3 font-weight-normal">Inserisci un nuovo prodotto nel catalogo</h1>
		<form action="/Shop/insertNewShop" method="post">
			
			<label for="name" class="sr-only">Nome</label> 
			<input type="text" name="name" id="name" class="form-control" placeholder="name" required autofocus /> 
				
			<label for="type" class="sr-only">Tipo</label> 
			<input type="type" name="type" id="type" class="form-control" placeholder="type" required> 
			
			<label for="price" class="sr-only">Price</label> 
			<input type="number" min="1" name="price" id="price" class="form-control" placeholder="price" required>
			
			<button class="btn btn-lg btn-primary btn-block" type="submit">Inserisci il nuovo prodotto</button>
			
		</form>
	</div>
	
</body>
</html>