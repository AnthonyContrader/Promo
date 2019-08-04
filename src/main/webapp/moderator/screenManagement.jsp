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

<title>Home Moderator</title>

<%@ include file="/css/header.jsp" %>

</head>

<body>
<%
	List<ScreenDTO> listScreen = (List<ScreenDTO>) request.getAttribute("allScreenDTO");
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
       		<a href="/Moderator/viewNewScreen" type="button" class="btn btn-primary">Inserisci New Screen</a>
       		<a href="/User/logout" type="button" class="btn btn-black">Logout</a>
           	<table class="table table-striped">
				<tr>
					<th>Idscreen</th>
					<th>Idmoderator</th>
					<th>Output</th>
					<th>Position</th>
					<th></th>
					<th></th>
				</tr>
				<%
					for(ScreenDTO screen: listScreen){
				 %>
				 	<tr>
				 		<td><%=screen.getIdscreen()%></td>
				 		<td><%=screen.getUser().getId()%></td>
				 		<td><%=screen.getOutput()%></td>
				 		<td><%=screen.getPosition()%></td>
				 		<td><a href="/Moderator/viewScreenUpdate?idscreen=<%=screen.getIdscreen()%>&idmoderator=<%=screen.getUser().getId()%>">Modifica</a></td>
				 		<td><a href="/Moderator/deleteScreen?idscreen=<%=screen.getIdscreen() %>">Cancella</a></td>
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