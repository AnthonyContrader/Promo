<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="java.util.List" %>
<%@	page import="it.contrader.dto.CatalogDTO"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>homeCatalog</title>

<%@ include file="/css/header.jsp" %>

</head>

<body>
<%
	CatalogDTO catalogUpdate = (CatalogDTO) request.getAttribute("catalog");
%>

	
<div class="row">
    <div class="col-8">
    	<form action="/Catalog/updateCatalog"  method="POST">
    		
    		<input type="hidden" name="id" value="<%=catalogUpdate.getIdcatalog()%>" />
    		
			<label for="name" class="sr-only">Nome</label> 
			<input type="text" name="name" id="name" class="form-control" value="<%=catalogUpdate.getName()%>" required autofocus /> 
			
			<label for="type" class="sr-only">Tipo</label> 
			<input type="text" name="type" id="type" class="form-control" value="<%=catalogUpdate.getType()%>" required> 
			
			<label for="price" class="sr-only">Price</label> 
			<input type="number" min="1" name="price" id="price" class="form-control" value="<%=catalogUpdate.getPrice()%>" required>
			
			<button class="btn btn-lg btn-primary btn-block" type="submit">Salva le modifiche sul catalogo del prodotto</button>
		</form>
   </div>
</div>
		
</body>
</html>