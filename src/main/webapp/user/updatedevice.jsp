<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.DeviceDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Device</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="DeviceServlet?mode=userlist">Device</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%DeviceDTO u = (DeviceDTO) request.getAttribute("dto");%>


<form id="floatleft" action="DeviceServlet?mode=update&id=<%=u.getIddevice()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="lbMac">Mac</label>
    </div>
    <div class="col-75">
      <input type="text" id="mac" name="mac" value=<%=u.getMac()%>>
    </div>
    
  </div>
  <div class="row">
    <div class="col-25">
     <label for="lbDevtype">DevType</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="devtype" name="devtype" value=<%=u.getDevtype()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Posizione</label>
    </div>
   		 <div class="col-75">
 			<input
  				type="text" id="position" name="position" value=<%=u.getPosition()%>> 
		</div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>