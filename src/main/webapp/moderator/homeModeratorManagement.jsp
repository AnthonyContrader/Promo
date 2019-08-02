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

<title>homeUser</title>

<%@ include file="/css/header.jsp" %>

</head>

<body>
<%
	List<ClientDTO> listClient = (List<ClientDTO>) request.getAttribute("allClientDTO");
%>
	 <div class="row">
	 	<div class="col-4">
	 		<div class="media">
			  <img src="https://picsum.photos/100" class="mr-3">
			  <div class="media-body">
			    <h5 class="mt-0">Benvenuto!</h5>
			  </div>
			</div>
	 	</div>
       	<div class="col-8">
       		<a href="/Client/viewNewClient" type="button" class="btn btn-primary">Inserisci New Client</a>
       		<a href="/User/logout" type="button" class="btn btn-black">Logout</a>
           	<table class="table table-striped">
				<tr>
					<th>Idclient</th>
					<th>Idmoderator</th>
					<th>Username</th>
					<th>Password</th>
					<th>Scode</th>
					<th>Email</th>
					<th></th>
					<th></th>
				</tr>
				<%
					for(ClientDTO client: listClient){
				 %>
				 	<tr>
				 		<td><%=client.getIdclient()%></td>
				 		<td><%=client.getUser()%></td>
				 		<td><%=client.getUsername()%></td>
				 		<td><%=client.getPassword()%></td>
				 		<td><%=client.getScode()%></td>
				 		<td><%=client.getEmail()%></td>
				 		<td><a href="/Client/viewClientUpdate?idclient=<%=client.getIdclient()%>">Modifica</a></td>
				 		<td><a href="/Client/deleteClient?id=<%=client.getIdclient() %>">Cancella</a></td>
				 	</tr>
				<% 
					}
				%>
			</table>
		</div>
     </div>
	
	
</body>
</html>