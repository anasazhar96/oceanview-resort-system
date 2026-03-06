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
String success = request.getParameter("success");
String error = request.getParameter("error");

if ("true".equals(success)) {
%>
    <script>
        alert("Reservation confirmed successfully!");
    </script>
<%
}

if ("true".equals(error)) {
%>
    <script>
        alert("Reservation failed. Please try again.");
    </script>
<%
}
%>

<%
    if(session.getAttribute("user") == null){
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }
%>
<h2>Ocean View Resort Dashboard</h2>

<h3>Reservation System Menu</h3>

<ul>
<li><a href="<%= request.getContextPath() %>/jsp/addReservation.jsp">Add Reservation</a></li>
<li><a href="<%= request.getContextPath() %>/jsp/viewReservation.jsp"> View Reservation</a></li>
<li><a href="#">Calculate Bill</a></li>
<li><a href="#">Help</a></li>
<li><a href="#">Exit System</a></li>	
</ul>

</body>
</html>