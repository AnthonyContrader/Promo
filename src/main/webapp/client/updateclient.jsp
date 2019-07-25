<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ClientDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Modifica Client</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homemoderator.jsp">Home</a>
  <a class="active" href="ClientServlet?mode=clientlist">Clients</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%ClientDTO u = (ClientDTO) request.getAttribute("dto");%>


<form id="floatleft" action="ClientServlet?mode=update&idclient=<%=u.getId()%>" method="post">
 <div class="row">
    <div class="col-25">
     <label for="idclient">id</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="idclient" name="idclient" value=<%=u.getId()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="idmoderator">idmoderator</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="idmoderator" name="idmoderator" value=<%=u.getIdmoderator()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="user">Username</label>
    </div>
    <div class="col-75">
      <input type="text" id="user" name="username" value=<%=u.getUsername()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Password</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="pass" name="password" value=<%=u.getPassword()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="scode">Scode</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="scode" name="scode" value=<%=u.getScode()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="email">Email</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="email" name="email" value=<%=u.getEmail()%>> 
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>