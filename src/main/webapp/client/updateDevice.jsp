<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="java.util.List" %>
<%@	page import="it.contrader.dto.DeviceDTO"%>

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
	DeviceDTO deviceUpdate = (DeviceDTO) request.getAttribute("device");
%>

	
<div class="row">
    <div class="col-8">
    	<form action="/Client/updateDevice"  method="POST">
    		<input type="hidden" name="iddevice" value="<%=deviceUpdate.getIddevice()%>" />
    		<label for="idclient" class="sr-only">Idclient</label> 
			<input type="number" name="idclient" id="idclient" class="form-control" value="<%=deviceUpdate.getClient().getIdclient()%>" required autofocus />
			<label for="mac" class="sr-only">Mac</label> 
			<input type="text" name="mac" id="mac" class="form-control" value="<%=deviceUpdate.getMac()%>" required /> 
			<label for="devtype" class="sr-only">Devtype</label> 
			<input type="text" name="devtype" id="devtype" class="form-control" value="<%=deviceUpdate.getDevtype()%>" required> 
			<label for="position" class="sr-only">Position</label> 
			<input type="text" name="position" id="position" class="form-control" value="<%=deviceUpdate.getPosition()%>" required>
			
			<button class="btn btn-lg btn-primary btn-block" type="submit">Salva</button>
		</form>
   </div>
</div>

<%@ include file="/js/scripts.jsp" %>	
</body>
</html>