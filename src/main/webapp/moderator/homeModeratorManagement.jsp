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

<title>Moderator Management</title>

<%@ include file="/css/header.jsp" %>

</head>

<body>
<%
	List<ClientDTO> listClient = (List<ClientDTO>) request.getAttribute("allClientDTO");
%>
	 <div class="row" style="height: 100%;">
	 	<div class="col-3 p-3" style="background-color: #C1272D;">
	 		<div class="media">
			  <i class="fas fa-user-circle fa-5x ml-1 text-white"></i>
			  <div class="media-body ml-1">
			    <h5 class="mt-0 text-white">Moderator</h5>
			  </div>
			</div>
			<div class="container container-icon-admin d-flex justify-content-between mt-4">
				<button onclick="goBack()" type="button" class="btn" title="Indietro">
					<i class="fas fa-arrow-left fa-2x text-white"></i>
				</button>
				<a href="/Moderator/viewNewClient" ><i class="fas fa-plus-circle fa-2x text-white"></i></a>
       			<a href="/User/logout" ><i class="fas fa-sign-out-alt fa-2x text-white"></i></a>
       		</div>
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
			<div class="mt-5" style="width: 95%;">
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
					 		<td><%=client.getUser().getId()%></td>
					 		<td><%=client.getUsername()%></td>
					 		<td><%=client.getPassword()%></td>
					 		<td><%=client.getScode()%></td>
					 		<td><%=client.getEmail()%></td>
					 		<td><a href="/Moderator/viewClientUpdate?idclient=<%=client.getIdclient()%>&idmoderator=<%=client.getUser().getId()%>"><i class="fas fa-edit fa-2x text-warning"></i></a></td>
					 		<td><a href="/Moderator/deleteClient?idclient=<%=client.getIdclient() %>"><i class="fas fa-trash fa-2x text-danger"></i></a></td>
					 	</tr>
					<% 
						}
					%>
				</table>
			</div>
		</div>
     </div>
	
<%@ include file="/js/scripts.jsp" %>	
</body>
</html>