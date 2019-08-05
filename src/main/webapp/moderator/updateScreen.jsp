<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="java.util.List" %>
<%@	page import="it.contrader.dto.ScreenDTO"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Update Screen</title>

<%@ include file="/css/header.jsp" %>

</head>

<body>
<%
	ScreenDTO screenUpdate = (ScreenDTO) request.getAttribute("screen");
%>

	
<div class="row">
    <div class="col-8">
    	<form action="/Moderator/updateScreen"  method="POST">
    		<input type="hidden" name="idscreen" value="<%=screenUpdate.getIdscreen()%>" />
    		<label for="idmoderator" class="sr-only">Idmoderator</label> 
			<input type="number" name="idmoderator" id="idmoderator" class="form-control" value="<%=screenUpdate.getUser().getId()%>" required autofocus />
			<label for="output" class="sr-only">Output</label> 
			<input type="text" name="output" id="output" class="form-control" value="<%=screenUpdate.getOutput()%>" required /> 
			<label for="position" class="sr-only">"Position"</label> 
			<input type="text" name="position" id="position" class="form-control" value="<%=screenUpdate.getPosition()%>" required> 
			
			<button class="btn btn-lg btn-primary btn-block" type="submit">Salva</button>
		</form>
   </div>
</div>

<%@ include file="/js/scripts.jsp" %>	
</body>
</html>