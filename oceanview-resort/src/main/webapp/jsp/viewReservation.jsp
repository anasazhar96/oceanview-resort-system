<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Reservation</title>
</head>
<body>

<h2>Search Reservation</h2>

<form action="<%= request.getContextPath() %>/viewReservation" method="get">

<%@ page import="com.oceanview.model.Reservation" %>

<%
    Reservation reservation = (Reservation) request.getAttribute("reservation");
    if (reservation != null) {
%>
    <h3>Reservation Details</h3>
    <p><strong>Reservation ID:</strong> <%= reservation.getReservationId() %></p>
    <p><strong>Reservation Number:</strong> <%= reservation.getReservationNo() %></p>
    <p><strong>Guest Name:</strong> <%= reservation.getGuestName() %></p>
    <p><strong>Address:</strong> <%= reservation.getAddress() %></p>
    <p><strong>Contact Number:</strong> <%= reservation.getContactNumber() %></p>
    <p><strong>Room Type:</strong> <%= reservation.getRoomType() %></p>
    <p><strong>Check-In Date:</strong> <%= reservation.getCheckIn() %></p>
    <p><strong>Check-Out Date:</strong> <%= reservation.getCheckOut() %></p>
<%
    } else if (request.getParameter("reservationNo") != null) {
%>
    <p style="color:red;">No reservation found for the given reservation number.</p>
<%
    }
%>


    <label>Reservation Number:</label><br>
    <input type="text" name="reservationNo" required><br><br>

    <button type="submit">Search</button>

</form>

</body>
</html>