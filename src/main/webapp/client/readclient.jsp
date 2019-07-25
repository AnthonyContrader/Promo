<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ClientDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Client</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homemoderator.jsp">Home</a>
  <a class="active"  href="ClientServlet?mode=clientlist">Clients</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%ClientDTO u = (ClientDTO) request.getAttribute("dto");%>


<table>
	<tr> 
	    <th>Idclient</th>
	    <th>Idmoderator</th>
		<th>Username</th>
		<th>Password</th>
		<th>Scode</th>
		<th>Email</th>
	</tr>
	<tr>
	    <td><%=u.getId()%></td>
	    <td><%=u.getIdmoderator()%></td>
		<td><%=u.getUsername()%></td>
		<td> <%=u.getPassword()%></td>
		<td> <%=u.getScode()%></td>
		<td><%=u.getEmail()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>