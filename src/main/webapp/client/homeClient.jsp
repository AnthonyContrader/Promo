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

	
	<h1>Sono in Home Client</h1>
	<p>ciao <%=client.getUsername().toUpperCase()%></p>
	
	<ul>
		<li>Profilo</li>
		<li><a href="/Client/deviceManagement">Device</a></li>
	</ul>
	
<%@ include file="/js/scripts.jsp" %>
</body>
</html>