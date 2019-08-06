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
	List<UserDTO> listUser = (List<UserDTO>) request.getAttribute("allUserDTO");
%>
	 <div class="row" style="height: 100%;">
	 	<div class="col-3 p-3" style="background-color: #C1272D;">
	 		<div class="media">
			  <i class="fas fa-user-circle fa-5x ml-1 text-white"></i>
			  <div class="media-body ml-1">
			    <h5 class="mt-0 text-white">Admin</h5>
			  </div>
			</div>
			<div class="container container-icon-admin d-flex justify-content-between mt-4">
				<a href="/User/viewNewUser" title="Insert New User">
					<i class="fas fa-plus-circle fa-2x text-white"></i>
				</a>
				<a href="/User/logout" title="Logout">
					<i class="fas fa-sign-out-alt fa-2x text-white"></i>
				</a>
				
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
       		
           	<table class="table table-striped mt-5">
				<tr>
					<th>Id</th>
					<th>Username</th>
					<th>Password</th>
					<th>Usertype</th>
					<th>Barcode</th>
					<th>Scode</th>
					<th></th>
					<th></th>
				</tr>
				<%
					for(UserDTO user: listUser){
				 %>
				 	<tr>
				 		<td><%=user.getId()%></td>
				 		<td><%=user.getUsername()%></td>
				 		<td><%=user.getPassword()%></td>
				 		<td><%=user.getUsertype()%></td>
				 		<td><%=user.getBarcode()%></td>
				 		<td><%=user.getScode()%></td>
				 		<td><a href="/User/viewUserUpdate?id=<%=user.getId()%>" title="Modifica"><i class="fas fa-edit fa-2x text-warning"></i></a></td>
				 		<td><a href="/User/deleteUser?id=<%=user.getId() %>" title="Cancella"><i class="fas fa-trash fa-2x text-danger"></i></a></td>
				 	</tr>
				<% 
					}
				%>
			</table>
		</div>
     </div>
	
<%@ include file="/js/scripts.jsp" %>	
</body>
</html>