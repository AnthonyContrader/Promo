<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.DeviceDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Device Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="DeviceServlet?mode=devicelist">Devices</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<DeviceDTO> list = (List<DeviceDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>IdDevice</th>
			<th>Mac</th>
			<th>Devtype</th>
			<th>Position</th>
			<th></th>
		</tr>
		<%
			for (DeviceDTO u : list) {
		%>
		<tr>
			<td><a href=DeviceServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getMac()%>
			</a></td>
			<td><%=u.getDevtype()%></td>
			<td><%=u.getPosition()%></td>
			<td><a href=DeviceServlet?mode=read&update=true&id=<%=u.getIddevice()%>>Edit</a>
			</td>
			<td><a href=DeviceServlet?mode=delete&id=<%=u.getIddevice()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="DeviceServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="mac">Mac</label>
    </div>
    <div class="col-75">
      <input type="text" id="mac" name="mac" placeholder="Inserisci il MAC adress">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="devtype">Devtype</label>
    </div>
    <div class="col-75">
      <input type="text" id="devtype" name="devtype" placeholder="Inserisci il devtype del device"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Posizione</label>
    </div>
   		 <div class="col-75">
 			<select id="type" name="position">
  				<option value="negozio 1">negozio 1</option>
  				<option value="negozio 2">negozio 2</option>
  				<option value="negozio 3">negozio 3</option>
  				<option value="negozio 4">negozio 4</option>
  				<option value="negozio 5">negozio 5</option>
  				<option value="negozio 6">negozio 6</option>
  				<option value="negozio 7">negozio 7</option>
  				<option value="negozio 8">negozio 8</option>
			</select>
    	</div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>