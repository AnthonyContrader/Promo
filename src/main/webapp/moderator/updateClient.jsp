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

<title>Update Client</title>

<%@ include file="/css/header.jsp" %>

</head>

<body>
<%
	ClientDTO clientUpdate = (ClientDTO) request.getAttribute("client");
%>

	
<div class="row">
    <div class="col-8">
    	<form action="/Moderator/updateClient"  method="POST">
    		<input type="hidden" name="idclient" value="<%=clientUpdate.getIdclient()%>" />
    		<label for="idmoderator" class="sr-only">Idmoderator</label> 
			<input type="number" name="idmoderator" id="idmoderator" class="form-control" value="<%=clientUpdate.getUser().getId()%>" required autofocus />
			<label for="username" class="sr-only">Username</label> 
			<input type="text" name="username" id="username" class="form-control" value="<%=clientUpdate.getUsername()%>" required /> 
			<label for="password" class="sr-only">Password</label> 
			<input type="text" name="password" id="password" class="form-control" value="<%=clientUpdate.getPassword()%>" required> 
			<label for="scode" class="sr-only">Scode</label> 
			<input type="text" name="scode" id="scode" class="form-control" value="<%=clientUpdate.getScode()%>" required>
			<label for="email" class="sr-only">Email</label> 
			<input type="text" name="email" id="email" class="form-control" value="<%=clientUpdate.getEmail()%>" required>
			
			<button class="btn btn-lg btn-primary btn-block" type="submit">Salva</button>
		</form>
   </div>
</div>

<%@ include file="/js/scripts.jsp" %>	
</body>
</html>