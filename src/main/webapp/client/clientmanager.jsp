<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.ClientDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/vittoriostyle.css" rel="stylesheet">
<title>Client Manager</title>
</head>
<body>


<div class="navbar">
  <a  href="homemoderator.jsp">Home</a>
  <a class="active" href="ClientServlet?mode=clientlist">Clients</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<ClientDTO> list = (List<ClientDTO>) request.getAttribute("list");
	%>

<br>

	<table>
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
			for (ClientDTO u : list) {
		%>
		<tr> 
			<td>				
				<%=u.getId()%>
			</td>
			<td><%=u.getIdmoderator()%></td>
			<td>
				<a href="ClientServlet?mode=read&idclient=<%=u.getId()%>">
					<%=u.getUsername()%> 
				</a>
			</td>
			<td><%=u.getPassword()%></td>
			<td><%=u.getScode()%></td>
			<td><%=u.getEmail()%></td>
			
			<td>
				<a href="ClientServlet?mode=read&update=true&idclient=<%=u.getId()%>&idmoderator=<%=u.getIdmoderator()%>">Modifica</a>
			</td>
			<td><a href="ClientServlet?mode=delete&idclient=<%=u.getId()%>">Cancella</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="ClientServlet?mode=insert" method="post">
   <div class="row">
	    <div class="col-25">
	      <label for="idmoderator">Idmoderator</label>
	    </div>
    <div class="col-75">
      	<input type="number" id="idmoderator" name="idmoderator" placeholder="inserisci id_moderator">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="username">Username</label>
    </div>
    <div class="col-75">
      <input type="text" id="username" name="username" placeholder="inserisci username">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     	<label for="password">Password</label>
    </div>
    <div class="col-75">
      	<input type="text" id="password" name="password" placeholder="inserisci password"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     	<label for="scode">Scode</label>
    </div>
    <div class="col-75">
      	<input type="text" id="scode" name="scode" placeholder="inserisci scode alfanumerico">
    </div>
  </div>
  <div class="row">
	   <div class="col-25">
	     <label for="email">Email</label>
	   </div>
	   <div class="col-75">
	     <input type="text" id="email" name="email" placeholder="inserisci l'email">
	   </div>
  </div> 
  <button type="submit" >INSERISCI</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>