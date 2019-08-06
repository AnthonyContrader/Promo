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
	
	<div class="row" style="height: 100%;">
	 	<div class="col-3 p-3" style="background-color: #C1272D;">
	 		<div class="media">
			  <i class="fas fa-user-circle fa-5x ml-1 text-white"></i>
			  <div class="media-body ml-1">
			    <h5 class="mt-0 text-white">CLIENT</h5>
			  </div>
			</div>
			<div class="container container-icon-admin d-flex justify-content-between mt-4">
	       		<button onclick="goBack()" type="button" class="btn" title="Indietro">
						<i class="fas fa-arrow-left fa-2x text-white"></i>
				</button>
	       		<a href="/Client/viewNewDevice" title="Inserisci New Device">
	       			<i class="fas fa-plus-circle fa-2x text-white"></i>
	       		</a>       
	       		<a href="/Client/logout" title="Logout">
	       			<i class="fas fa-sign-out-alt fa-2x text-white"></i>
	       		</a>		
			</div>
	 	</div>
       	<div class="col-9 p-3">
       		<div class="d-flex">
       			<div class="hamburger-round mr-1 mb-1"></div>
       			<div class="hamburger-round mr-1 mb-1"></div>
       			<div class="hamburger-round mr-1 mb-1"></div>
       		</div>
			<div class="d-flex">
				<div class="hamburger-round mr-1 mb-1"></div>
       			<div class="hamburger-round mr-1 mb-1"></div>
       			<div class="hamburger-round mr-1 mb-1"></div>
			</div>
			<div class="d-flex">
				<div class="hamburger-round mr-1 mb-1"></div>
       			<div class="hamburger-round mr-1 mb-1"></div>
       			<div class="hamburger-round mr-1 mb-1"></div>
			</div>
			<div style="width: 95%;" class="mt-5"> 
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
					 		<td><a href="/Client/viewDeviceUpdate?iddevice=<%=device.getIddevice()%>&idclient=<%=device.getClient().getIdclient()%>"title="Modifica"><i class="fas fa-edit fa-2x text-warning"></i></a></td>
					 		<td><a href="/Client/deleteDevice?iddevice=<%=device.getIddevice() %>" title="Cancella"><i class="fas fa-trash fa-2x text-danger"></i></a></td>
					 	</tr>
					<% 
						}
					%>
				</table>
			</div>
		</div>
     </div>
	
<%@ include file="/js/scripts.jsp" %>
</body>
</html>