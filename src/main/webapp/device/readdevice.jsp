<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.DeviceDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="DeviceServlet?mode=devicelist">Dispositivi</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%DeviceDTO u = (DeviceDTO) request.getAttribute("dto");%>


<table>
	<tr> 
	    <th>Iddevice</th>
	    <th>Idowner</th>
		<th>MAC</th>
		<th>DevType</th>
		<th>Position</th>
	</tr>
	<tr>
	    <td><%=u.getIddevice()%></td>
	    <td><%=u.getIdowner()%></td>
		<td><%=u.getMac()%></td>
		<td> <%=u.getDevtype()%></td>
		<td> <%=u.getPosition()%></td>
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