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
       		<a href="/User/viewNewUser" type="button" class="btn btn-primary">Inserisci New User</a>
       		<a href="/User/logout" type="button" class="btn btn-black">Logout</a>
           	<table class="table table-striped">
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
				 		<td><a href="/User/viewUserUpdate?id=<%=user.getId()%>">Modifica</a></td>
				 		<td><a href="/User/deleteUser?id=<%=user.getId() %>">Cancella</a></td>
				 	</tr>
				<% 
					}
				%>
			</table>
		</div>
     </div>
	
	
</body>
</html>