<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calculate Bill</title>
</head>
<body>

<h2>Calculate Reservation Bill</h2>

<form action="<%= request.getContextPath() %>/calculateBill" method="get">

<%@ page import="com.oceanview.model.Reservation" %>

<%
    Reservation reservation = (Reservation) request.getAttribute("reservation");
    Double totalBill = (Double) request.getAttribute("totalBill");

    if (reservation != null) {
%>

<h3>Reservation Details</h3>

<p><strong>Reservation Number:</strong> <%= reservation.getReservationNo() %></p>
<p><strong>Guest Name:</strong> <%= reservation.getGuestName() %></p>
<p><strong>Room Type:</strong> <%= reservation.getRoomType() %></p>
<p><strong>Check-In:</strong> <%= reservation.getCheckIn() %></p>
<p><strong>Check-Out:</strong> <%= reservation.getCheckOut() %></p>

<h3>Total Bill: Rs. <%= totalBill %></h3>

<%
    } else if (request.getParameter("reservationNo") != null) {
%>

<p style="color:red;">Reservation not found.</p>

<%
    }
%>

    <label>Reservation Number:</label><br>
    <input type="text" name="reservationNo" required><br><br>

    <button type="submit">Calculate Bill</button>

</form>

</body>
</html>