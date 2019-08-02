<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="java.util.List" %>
<%@	page import="it.contrader.dto.UserDTO"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>homeUser</title>

<%@ include file="/css/header.jsp" %>

</head>

<body>
<%
	UserDTO userUpdate = (UserDTO) request.getAttribute("user");
%>

	
<div class="row">
    <div class="col-8">
    	<form action="/User/updateUser"  method="POST">
    		<input type="hidden" name="id" value="<%=userUpdate.getId()%>" />
			<label for="username" class="sr-only">Username</label> 
			<input type="text" name="username" id="username" class="form-control" value="<%=userUpdate.getUsername()%>" required autofocus /> 
			<label for="password" class="sr-only">Password</label> 
			<input type="text" name="password" id="password" class="form-control" value="<%=userUpdate.getPassword()%>" required> 
			<label for="usertype" class="sr-only">Usertype</label> 
			<input type="text" name="usertype" id="usertype" class="form-control" value="<%=userUpdate.getUsertype()%>" required>
			<label for="barcode" class="sr-only">Barcode</label> 
			<input type="number" min="1" name="barcode" id="barcode" class="form-control" value="<%=userUpdate.getBarcode()%>" required>
			<label for="scode" class="sr-only">Scode</label> 
			<input type="text" name="scode" id="scode" class="form-control" value="<%=userUpdate.getScode()%>" required>
			
			<button class="btn btn-lg btn-primary btn-block" type="submit">Salva</button>
		</form>
   </div>
</div>
		
</body>
</html>