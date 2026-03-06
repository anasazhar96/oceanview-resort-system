<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ocean View Resort Dashboard</title>
</head>

<body>
<%
    if(session.getAttribute("user") == null){
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }
%>
<h2>Ocean View Resort Dashboard</h2>

<h3>Reservation System Menu</h3>

<ul>
<li><a href="#">Add Reservation</a></li>
<li><a href="#">View Reservation</a></li>
<li><a href="#">Calculate Bill</a></li>
<li><a href="#">Help</a></li>
<li><a href="#">Exit System</a></li>
</ul>

</body>
</html>