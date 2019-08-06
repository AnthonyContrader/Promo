<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="java.util.List" %>
<%@	page import="it.contrader.dto.ClientDTO"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Home Client</title>

<%@ include file="/css/header.jsp" %>

<%
	ClientDTO client = (ClientDTO) request.getAttribute("client");
%>

</head>

<body>
	<div class="row" style="height: 100%;">
	 	<div class="col-3 p-3" style="background-color: #C1272D;">
	 		<div class="media">
			  <i class="fas fa-user-circle fa-5x ml-1 text-white"></i>
			  <div class="media-body ml-1">
			    <h5 class="mt-0 text-white"><%=client.getUsername().toUpperCase()%></h5>
			  </div>
			</div>	
			<ul class="list-group mt-3">
				<li class="list-group-item">Profilo</li>
				<li class="list-group-item"><a href="/Client/deviceManagement">Device</a></li>
			</ul>
			<button onclick="goBack()" type="button" class="btn" title="Indietro">
				<i class="fas fa-arrow-left fa-2x text-white"></i>
			</button>
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
		</div>
	
<%@ include file="/js/scripts.jsp" %>
</body>
</html>