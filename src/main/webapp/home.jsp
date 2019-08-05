<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Home</title>

<%@ include file="/css/header.jsp" %>
</head>

<body>
<nav class='navbar navbar-inverse'>
     <div class='container-fluid'>
         <ul class='nav navbar-nav navbar-inverse navbar-custom'>
            <li><a href="/Home/userManagement/">User</a></li>
            <li><a href="/Home/chatManagement/">Chatbot</a></li>
            <li><a href="/Home/logout/">Logout</a></li>
         </ul>
    </div>
</nav>
<h1>Progetto METABOT</h1>

<%@ include file="/js/scripts.jsp" %>
</body>
</html>