<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ page import="java.util.List" %>
<%@	page import="it.contrader.dto.ShopDTO"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Home Shop</title>

<%@ include file="/css/header.jsp" %>

</head>

<body>
<%
	List<ShopDTO> listShop = (List<ShopDTO>) request.getAttribute("allShopDTO");
%>
	<div class="row" style="height: 100%;">
	 	<div class="col-3 p-3" style="background-color: #C1272D;">
	 		<div class="media">
			  <i class="fas fa-user-circle fa-5x ml-1 text-white"></i>
			  <div class="media-body ml-1">
			    <h5 class="mt-0 text-white">Moderator</h5>
			  </div>
			</div>
			<div class="container container-icon-admin d-flex justify-content-between mt-4">
				<button onclick="goBack()" type="button" class="btn" title="Indietro">
					<i class="fas fa-arrow-left fa-2x text-white"></i>
				</button>
			   	<a href="/Moderator/viewNewShop" title="Inserisci New Shop">
			   		<i class="fas fa-plus-circle fa-2x text-white"></i>
			   	</a>
       			<a href="/User/logout" title="Logout">
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
						<th>Idshop</th>
						<th>Idmoderator</th>
						<th>Name</th>
						<th>Type</th>
						<th>Position</th>
						<th>Barcode</th>
						<th></th>
						<th></th>
					</tr>
					<%
						for(ShopDTO shop: listShop){
					 %>
					 	<tr>
					 		<td><%=shop.getIdshop()%></td>
					 		<td><%=shop.getUser().getId()%></td>
					 		<td><%=shop.getName()%></td>
					 		<td><%=shop.getType()%></td>
					 		<td><%=shop.getPosition()%></td>
					 		<td><%=shop.getBarcode()%></td>
					 		<td><a href="/Moderator/viewShopUpdate?idshop=<%=shop.getIdshop()%>&idmoderator=<%=shop.getUser().getId()%>" title="Modifica"><i class="fas fa-edit fa-2x text-warning"></i></a></td>
					 		<td><a href="/Moderator/deleteShop?idshop=<%=shop.getIdshop() %>" title="Cancella"><i class="fas fa-trash fa-2x text-danger"></i></a></td>
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