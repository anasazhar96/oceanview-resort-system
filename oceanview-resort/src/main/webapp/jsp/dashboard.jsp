<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ocean View Resort Dashboard</title>
<head>
<meta charset="UTF-8">
<title>Ocean View Resort Dashboard</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
</head>
<body>

<div class="container">
<%
    String success = request.getParameter("success");
    String error = request.getParameter("error");
    String resNo = request.getParameter("resNo");
%>

<%
    if(session.getAttribute("user") == null){
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }
%>

<%
    if ("true".equals(success)) {
%>
    <script>
    	alert("Reservation created successfully! Reservation Number: <%= resNo %>");
    </script>
<%
    }
%>

<%
    if ("true".equals(error)) {
%>
    <script>
        alert("Reservation failed. Please try again.");
    </script>
<%
    }
%>

<h2>Ocean View Resort Dashboard</h2>

<h3>Reservation System Menu</h3>

<ul class="menu">
    <li><a href="<%= request.getContextPath() %>/jsp/addReservation.jsp">Add Reservation</a></li>
    <li><a href="<%= request.getContextPath() %>/jsp/viewReservation.jsp">View Reservation</a></li>
    <li><a href="<%= request.getContextPath() %>/jsp/calculateBill.jsp">Calculate Bill</a></li>
    <li><a href="<%= request.getContextPath() %>/viewAllReservations">View All Reservations</a></li>
    <li><a href="<%= request.getContextPath() %>/jsp/help.jsp">Help</a></li>
    <li><a href="<%= request.getContextPath() %>/logout">Logout</a></li>
</ul>

</div>
</body>
</html>
