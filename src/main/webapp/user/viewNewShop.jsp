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
		<h1 class="h3 mb-3 font-weight-normal">Inserisci New Shop</h1>
		<form action="/Shop/insertNewShop" method="post">
			
			<label for="name" class="sr-only">Nome dello shop</label> 
			<input type="text" name="name" id="name" class="form-control" placeholder="name" required autofocus /> 

			<label for="position" class="sr-only">Posizione</label> 
			<input type="position" name="position" id="position" class="form-control" placeholder="position" required>
						
			<label for="type" class="sr-only">Tipo</label> 
			<input type="type" name="type" id="type" class="form-control" placeholder="type" required> 
			
			<label for="barcode" class="sr-only">Barcode</label> 
			<input type="number" min="1" name="barcode" id="barcode" class="form-control" placeholder="Barcode" required>
			
			<button class="btn btn-lg btn-primary btn-block" type="submit">Inserisci il nuovo Shop</button>
			
		</form>
	</div>
	
</body>
</html>