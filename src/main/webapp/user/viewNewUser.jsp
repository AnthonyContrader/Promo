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
	<div class="row" style="height: 100%;">
	 	<div class="col-3 p-3" style="background-color: #C1272D;">
	 		<div class="media">
			  <i class="fas fa-user-circle fa-5x ml-1 text-white"></i>
			  <div class="media-body ml-1">
			    <h5 class="mt-0 text-white">Admin</h5>
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
			<h1 class="h3 mb-3 font-weight-normal">Inserisci New User</h1>
			<div style="width: 95%;">
				<form action="/User/insertNewUser" method="post">
					<label for="username" class="sr-only">Username</label> 
					<input type="text" name="username" id="username" class="form-control" placeholder="Username" required autofocus /> 
					<label for="password" class="sr-only">Password</label> 
					<input type="text" name="password" id="password" class="form-control" placeholder="Password" required> 
					<label for="usertype" class="sr-only">Usertype</label> 
					<input type="text" name="usertype" id="usertype" class="form-control" placeholder="Usertype" required>
					<label for="barcode" class="sr-only">Barcode</label> 
					<input type="number" min="1" name="barcode" id="barcode" class="form-control" placeholder="Barcode" required>
					<label for="scode" class="sr-only">Scode</label> 
					<input type="text" name="scode" id="scode" class="form-control" placeholder="Scode" required>
					
					<button class="btn btn-lg float-right btn-success" type="submit">Inserisci</button>
				</form>
			</div>
			
		</div>
	</div>
	
<%@ include file="/js/scripts.jsp" %>
</body>
</html>