<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.ClientDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Moderator</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
<%@include file="css/header.jsp"%>


<div class="navbar">
  <a class="active" href="homemoderator.jsp">Home</a>
  <a href="ClientServlet?mode=clientlist">Clients</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<div class="main">
<h1>BENVENUTO ${user.getUsername()}</h1>

QUI POTRAI GESTIRE LA LISTA DEI TUOI CLIENTI, NELL'APPOSITA SEZIONE CLIENTS

</div>


<%@ include file="css/footer.jsp" %>

</body>
</html>