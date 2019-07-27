<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.DeviceDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/vittoriostyle.css" rel="stylesheet">
<title>Device Manager</title>
</head>
<body>


<div class="navbar">
  <a  href="homemoderator.jsp">Home</a>
  <a class="active" href="ClientServlet?mode=clientlist">Clients</a>
  <a class="active" href="DeviceServlet?mode=devicelist">Dispositivi</a>
  <a class="active" href="ScreenServlet?mode=screenlist">Screen</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<DeviceDTO> list = (List<DeviceDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Iddevice</th>
			<th>Idowner</th>
			<th>Mac</th>
			<th>Devtype</th>
			<th>Position</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (DeviceDTO u : list) {
		%>
		<tr>
		    <td>				
				<%=u.getIddevice()%>
			</td>
			<td><%=u.getIdowner()%></td>
			
	        <td><a href="DeviceServlet?mode=read&iddevice=<%=u.getIddevice()%>">
					<%=u.getMac()%>
			   </a>
			<td><%=u.getDevtype()%></td>
			<td><%=u.getPosition()%></td>
			<td>
			    <a href="DeviceServlet?mode=read&update=true&iddevice=<%=u.getIddevice()%>&idowner=<%=u.getIdowner()%>">Modifica</a>
			</td>
			<td><a href=DeviceServlet?mode=delete&iddevice=<%=u.getIddevice()%>>Cancella</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="DeviceServlet?mode=insert" method="post">
    
   <div class="row">
	    <div class="col-25">
	      <label for="Idowner">Idowner</label>
	    </div>
    <div class="col-75">
      	<input type="number" id="Idowner" name="Idowner" placeholder="inserisci id_Idowner" min="1">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="mac">MAC</label>
    </div>
    <div class="col-75">
      <input type="text" id="mac" name="mac" placeholder="inserisci il MAC del dispositivo">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="devtype">Devtype</label>
    </div>
    <div class="col-75">
      <input type="text" id="devtype" name="devtype" placeholder="inserisci il devtype del dispositivo"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="type">Position</label>
    </div>
   		 <div class="col-75">
 			<select id="type" name="position">
 			
  				<option value="negozio 1">Negozio 1</option>
  				
  				<option value="negozio 2">Negozio 2</option>
  				
  				<option value="negozio 3">Negozio 3</option>
  				
  				<option value="negozio 4">Negozio 4</option>
 
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