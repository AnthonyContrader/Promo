<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>View New Client</title>

<%@ include file="/css/header.jsp" %>
</head>

<body>
	
	<div class="container container-center">
		<h1 class="h3 mb-3 font-weight-normal">Inserisci New Device</h1>
		<form action="/Moderator/insertNewScreen" method="post">
			<label for="idmoderator" class="sr-only">Idmoderator</label> 
			<input type="number" name="idmoderator" id="idmoderator" class="form-control" placeholder="idmoderator" required autofocus />
			<label for="output" class="sr-only">Output</label> 
			<input type="text" name="output" id="output" class="form-control" placeholder="Output" required /> 
			<label for="position" class="sr-only">Position</label> 
			<input type="text" name="position" id="position" class="form-control" placeholder="Position" required>  
						
			<button class="btn btn-lg btn-primary btn-block" type="submit">Inserisci</button>
		</form>
	</div>

<%@ include file="/js/scripts.jsp" %>	
</body>
</html>