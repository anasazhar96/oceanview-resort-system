<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.oceanview.model.Reservation" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculate Bill</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>

<div class="container">

<h2>Calculate Reservation Bill</h2>

<form action="<%= request.getContextPath() %>/calculateBill" method="get">
    <label>Reservation Number:</label><br>
    <input type="text" name="reservationNo" placeholder="Enter reservation number (e.g. R001)" pattern="R[0-9]{3,}" title="Reservation number should be like R001" required><br><br>

    <button type="submit">Calculate Bill</button>
</form>

<hr>

<%
    Reservation reservation = (Reservation) request.getAttribute("reservation");
    Double totalBill = (Double) request.getAttribute("totalBill");
    String guestName = (String) request.getAttribute("guestName");
    String errorMessage = (String) request.getAttribute("errorMessage");

    if (reservation != null) {
%>

    <h3>Reservation Details</h3>

    <p><strong>Reservation Number:</strong> <%= reservation.getReservationNo() %></p>
    <p><strong>Guest Name:</strong> <%= guestName %></p>
    <p><strong>Room Type:</strong> <%= reservation.getRoomType() %></p>
    <p><strong>Check-In:</strong> <%= reservation.getCheckIn() %></p>
    <p><strong>Check-Out:</strong> <%= reservation.getCheckOut() %></p>

    <h3>Total Bill: Rs. <%= totalBill %></h3>

<%
    } else if (errorMessage != null) {
%>

    <p style="color:red;"><%= errorMessage %></p>

<%
    }
%>
<br><br>

<a href="<%= request.getContextPath() %>/jsp/dashboard.jsp">
<button type="button">Back to Dashboard</button>
</a>

</div>>
</body>
</html>