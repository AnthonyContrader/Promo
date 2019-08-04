<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>View New Device</title>

<%@ include file="/css/header.jsp" %>
</head>

<body>
	
	<div class="container container-center">
		<h1 class="h3 mb-3 font-weight-normal">Inserisci New Device</h1>
		<form action="/Client/insertNewDevice" method="post">
			<label for="idclient" class="sr-only">Idclient</label> 
			<input type="number" name="idclient" id="idclient" class="form-control" placeholder="idclient" required autofocus />
			<label for="mac" class="sr-only">Mac</label> 
			<input type="text" name="mac" id="mac" class="form-control" placeholder="Mac" required autofocus /> 
			<label for="devtype" class="sr-only">Devtype</label> 
			<input type="text" name="devtype" id="devtype" class="form-control" placeholder="Devtype" required> 
			<label for="position" class="sr-only">Position</label> 
			<input type="text" name="position" id="position" class="form-control" placeholder="Position" required>			
						
			<button class="btn btn-lg btn-primary btn-block" type="submit">Inserisci</button>
			
		</form>
	</div>

<%@ include file="/js/scripts.jsp" %>	
</body>
</html>