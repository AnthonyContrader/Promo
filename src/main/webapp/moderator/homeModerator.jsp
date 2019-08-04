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

<title>homeModerator</title>

<%@ include file="/css/header.jsp" %>

</head>

<body>
	
	<ul>
		<li><a href="/Moderator/viewAllClients/">Clients</a></li>
		<li><a href="/Moderator/viewAllScreens/">Screens</a></li>
	</ul>

<%@ include file="/js/scripts.jsp" %>
</body>
</html>