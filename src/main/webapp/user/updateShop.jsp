<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="java.util.List" %>
<%@	page import="it.contrader.dto.ShopDTO"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>homeShop</title>

<%@ include file="/css/header.jsp" %>

</head>

<body>
<%
	ShopDTO catalogUpdate = (ShopDTO) request.getAttribute("catalog");
%>

	
<div class="row">
    <div class="col-8">
    	<form action="/Shop/updateShop"  method="POST">
    		
    		<input type="hidden" name="id" value="<%=catalogUpdate.getIdshop()%>" />
			
			<label for="name" class="sr-only">Nome</label> 
			<input type="text" name="name" id="name" class="form-control" value="<%=catalogUpdate.getName()%>" required autofocus /> 
			
			<label for="type" class="sr-only">Posizione</label> 
			<input type="text" name="position" id="position" class="form-control" value="<%=catalogUpdate.getPosition()%>" required> 
			
			<label for="type" class="sr-only">Tipo</label> 
			<input type="text" name="type" id="type" class="form-control" value="<%=catalogUpdate.getType()%>" required> 
			
			<label for="barcode" class="sr-only">Price</label> 
			<input type="number" min="1" name="barcode" id="barcode" class="form-control" value="<%=catalogUpdate.getBarcode()%>" required>
			
			<button class="btn btn-lg btn-primary btn-block" type="submit">Salva le modifiche sullo Shop</button>
		</form>
   </div>
</div>
		
</body>
</html>