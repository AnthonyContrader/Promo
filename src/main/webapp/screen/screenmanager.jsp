<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.ScreenDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/vittoriostyle.css" rel="stylesheet">
<title>Screen Manager</title>
</head>
<body>


<div class="navbar">
  <a  href="homemoderator.jsp">Home</a>
  <a class="active" href="ScreenServlet?mode=screenlist">Screens</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<ScreenDTO> list = (List<ScreenDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
		    <th>Idscreen</th>
			<th>Output</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (ScreenDTO u : list) {
		%>
		<tr>
			<td>
			        <%=u.getIdscreen()%>
			<td>        
			    <a href=ScreenServlet?mode=read&idscreen=<%=u.getIdscreen()%>>
					<%=u.getOutput()%>
			    </a></td>
            <td>
                <a href="ScreenServlet?mode=read&update=true&idscreen=<%=u.getIdscreen()%>">Modifica</a>
			</td>
			<td>
			    <a href=ScreenServlet?mode=delete&idscreen=<%=u.getIdscreen()%>>Cancella</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="ScreenServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="output">Output</label>
    </div>
    <div class="col-75">
      <input type="text" id="output" name="output" placeholder="inserisci output">
    </div>
  </div>
  <button type="submit">INSERISCI</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>