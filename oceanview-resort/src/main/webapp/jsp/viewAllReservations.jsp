<%@ page import="java.util.List,java.util.Map,com.oceanview.model.Reservation" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Reservations</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>

<div class="wide-container">

<h2>All Reservations</h2>

<table border="1">
<tr>
    <th>Reservation No</th>
    <th>Guest Name</th>
    <th>Contact</th>
    <th>Room Type</th>
    <th>Check-In</th>
    <th>Check-Out</th>
</tr>

<%
List<Map<String, Object>> reservations =
    (List<Map<String, Object>>) request.getAttribute("reservations");

if (reservations != null && !reservations.isEmpty()) {
    for (Map<String, Object> row : reservations) {
        Reservation r = (Reservation) row.get("reservation");
        String guestName = (String) row.get("guestName");
        String contact = (String) row.get("contactNumber");
%>
<tr>
    <td><%= r.getReservationNo() %></td>
    <td><%= guestName %></td>
    <td><%= contact %></td>
    <td><%= r.getRoomType() %></td>
    <td><%= r.getCheckIn() %></td>
    <td><%= r.getCheckOut() %></td>
</tr>
<%
    }
} else {
%>
<tr>
    <td colspan="6">No reservations found.</td>
</tr>
<%
}
%>

</table>

<br>
<a href="<%= request.getContextPath() %>/jsp/dashboard.jsp">Back to Dashboard</a>

</div>

</body>
</html>