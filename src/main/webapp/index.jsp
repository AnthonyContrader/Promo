<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>


<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>PROMO LOGIN PAGE</title>

<style>

	body {
		background: url('/img/sfondo_template_3.jpg');
	}
	
</style>

<%@ include file="/css/header.jsp" %>

</head>

<body>

	<div class="user-areariservata float-right mr-5 mt-5">
		<a href="/User/areariservata/"><i class="fas fa-lock fa-2x text-dark" title="Area Riservata"></i></a>
	</div>
	
	<div class="container-index">
		<div class="client-login-index">
			<a href="/Client/viewloginClient/" class="text-danger font-weight-bold">Login</a>
		</div>
		<div class="client-freeEnter-index mb-4">
			 <a href="/Client/freeEnter" class="text-white font-weight-bold">Entra</a>
		</div>
		<div class="title-index">
			<h1 class="text-danger">PROMO</h1>
		</div>
	</div>
	

<%@ include file="/js/scripts.jsp" %>

</body>
</html>