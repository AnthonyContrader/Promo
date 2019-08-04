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
		<h1 class="h3 mb-3 font-weight-normal">Inserisci New Client</h1>
		<form action="/Moderator/insertNewClient" method="post">
			<label for="idmoderator" class="sr-only">Idmoderator</label> 
			<input type="number" name="idmoderator" id="idmoderator" class="form-control" placeholder="idmoderator" required autofocus />
			<label for="username" class="sr-only">Username</label> 
			<input type="text" name="username" id="username" class="form-control" placeholder="Username" required /> 
			<label for="password" class="sr-only">Password</label> 
			<input type="password" name="password" id="password" class="form-control" placeholder="Password" required> 
			<label for="scode" class="sr-only">Scode</label> 
			<input type="text" name="scode" id="scode" class="form-control" placeholder="Scode" required>
			<label for="email" class="sr-only">Email</label> 
			<input type="text" name="email" id="email" class="form-control" placeholder="Email" required>
						
			<button class="btn btn-lg btn-primary btn-block" type="submit">Inserisci</button>
			
		</form>
	</div>

<%@ include file="/js/scripts.jsp" %>	
</body>
</html>