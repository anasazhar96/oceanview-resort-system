<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.oceanview.model.Reservation" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Reservation</title>
</head>
<body>

<h2>Search Reservation</h2>

<form action="<%= request.getContextPath() %>/viewReservation" method="get">
    <label>Reservation Number:</label><br>
    <input type="text" name="reservationNo" required><br><br>

    <button type="submit">Search</button>
</form>

<hr>

<%
    Reservation reservation = (Reservation) request.getAttribute("reservation");
    String guestName = (String) request.getAttribute("guestName");
    String address = (String) request.getAttribute("address");
    String contactNumber = (String) request.getAttribute("contactNumber");
    String errorMessage = (String) request.getAttribute("errorMessage");

    if (reservation != null) {
%>
    <h3>Reservation Details</h3>
    <p><strong>Reservation ID:</strong> <%= reservation.getReservationId() %></p>
    <p><strong>Reservation Number:</strong> <%= reservation.getReservationNo() %></p>
    <p><strong>Guest Name:</strong> <%= guestName %></p>
    <p><strong>Address:</strong> <%= address %></p>
    <p><strong>Contact Number:</strong> <%= contactNumber %></p>
    <p><strong>Room Type:</strong> <%= reservation.getRoomType() %></p>
    <p><strong>Check-In Date:</strong> <%= reservation.getCheckIn() %></p>
    <p><strong>Check-Out Date:</strong> <%= reservation.getCheckOut() %></p>
<%
    } else if (errorMessage != null) {
%>
    <p style="color:red;"><%= errorMessage %></p>
<%
    }
%>

</body>
</html>