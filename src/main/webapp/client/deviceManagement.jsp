<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="java.util.List" %>
<%@	page import="it.contrader.dto.ClientDTO"%>
<%@	page import="it.contrader.dto.DeviceDTO"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Device Management</title>

<%@ include file="/css/header.jsp" %>

</head>

<body>
<%
	List<DeviceDTO> listDevice = (List<DeviceDTO>) request.getAttribute("allDevice");
%>
	
	<div class="row">
	 	<div class="col-4">
	 		<div class="media">
			  <img src="https://picsum.photos/100" class="mr-3">
			  <div class="media-body">
			    <h5 class="mt-0">Device Management</h5>
			  </div>
			</div>
	 	</div>
       	<div class="col-8">
       	
       		<a href="/Client/viewNewDevice" type="button" class="btn btn-primary">Inserisci New Device</a>
       		<button onclick="goBack()" type="button" class="btn btn-black" onclick="goBack()">Indietro</button>
       		
           	<table class="table table-striped">
				<tr>
					<th>Iddevice</th>
					<th>Idclient</th>
					<th>Mac</th>
					<th>Devtype</th>
					<th>Position</th>
					<th></th>
					<th></th>
				</tr>
				<%
					for(DeviceDTO device: listDevice){
				 %>
				 	<tr>
				 		<td><%=device.getIddevice()%></td>
				 		<td><%=device.getClient().getIdclient()%></td>
				 		<td><%=device.getMac()%></td>
				 		<td><%=device.getDevtype()%></td>
				 		<td><%=device.getPosition()%></td>
				 		<td><a href="/Client/viewDeviceUpdate?iddevice=<%=device.getIddevice()%>&idclient=<%=device.getClient().getIdclient()%>">Modifica</a></td>
				 		<td><a href="/Client/deleteDevice?iddevice=<%=device.getIddevice() %>">Cancella</a></td>
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