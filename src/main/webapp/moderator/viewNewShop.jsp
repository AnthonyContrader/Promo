<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>View New Shop</title>

<%@ include file="/css/header.jsp" %>
</head>

<body>
	
	<div class="row" style="height: 100%;">
	 	<div class="col-3 p-3" style="background-color: #C1272D;">
	 		<div class="media">
			  <i class="fas fa-user-circle fa-5x ml-1 text-white"></i>
			  <div class="media-body ml-1">
			    <h5 class="mt-0 text-white">Moderator</h5>
			  </div>
			</div>
			<div class="container container-icon-admin d-flex justify-content-between mt-4">
				<button onclick="goBack()" type="button" class="btn" title="Indietro">
					<i class="fas fa-arrow-left fa-2x text-white"></i>
				</button>
				<a href="/User/logout" title="Logout">
					<i class="fas fa-sign-out-alt fa-2x text-white"></i>
				</a>
			</div>
	 	</div>
	 	<div class="col-9 p-3">
       		<div class="d-flex">
       			<div class="hamburger-round mr-1 mb-1"></div>
       			<div class="hamburger-round mr-1 mb-1"></div>
       			<div class="hamburger-round mr-1 mb-1"></div>
       		</div>
			<div class="d-flex">
				<div class="hamburger-round mr-1 mb-1"></div>
       			<div class="hamburger-round mr-1 mb-1"></div>
       			<div class="hamburger-round mr-1 mb-1"></div>
			</div>
			<div class="d-flex">
				<div class="hamburger-round mr-1 mb-1"></div>
       			<div class="hamburger-round mr-1 mb-1"></div>
       			<div class="hamburger-round mr-1 mb-1"></div>
			</div>
		<h1 class="h3 mb-3 font-weight-normal mt-5">Inserisci New Shop</h1>
		<div style="width: 95%;">
			<form action="/Moderator/insertNewShop" method="post">
				<label for="idmoderator" class="sr-only">Idmoderator</label> 
				<input type="number" name="idmoderator" id="idmoderator" class="form-control" placeholder="idmoderator" required autofocus />
				<label for="name" class="sr-only">Name</label> 
				<input type="text" name="name" id="name" class="form-control" placeholder="Name" required /> 
				<label for="type" class="sr-only">Type</label> 
				<input type="text" name="type" id="type" class="form-control" placeholder="Type" required> 
				<label for="position" class="sr-only">Position</label> 
				<input type="text" name="position" id="position" class="form-control" placeholder="Position" required>
				<label for="barcode" class="sr-only">Barcode</label> 
				<input type="text" name="barcode" id="barcode" class="form-control" placeholder="Barcode" required>
							
				<button class="btn btn-lg float-right btn-success" type="submit">Inserisci</button>	
			</form>
		</div>
	</div>

<%@ include file="/js/scripts.jsp" %>	
</body>
</html>