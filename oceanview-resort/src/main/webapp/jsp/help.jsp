<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Help - Ocean View Resort</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>

<div class="container">

<h2>Ocean View Resort Reservation System - Help</h2>

<h3>How to Use the System</h3>

<ol>
    <li>
        <b>Add Reservation</b><br>
        Use this option to create a new reservation by entering guest details,
        room type, and check-in/check-out dates. The system automatically
        generates a reservation number.
    </li>

    <li>
        <b>View Reservation</b><br>
        Search for an existing reservation using the reservation number
        to view the full reservation details.
    </li>

    <li>
        <b>Calculate Bill</b><br>
        Enter the reservation number to calculate the total bill
        based on the number of nights stayed and the room rate.
    </li>

    <li>
        <b>View All Reservations</b><br>
        Displays a report of all reservations currently stored in the system.
    </li>

    <li>
        <b>Logout</b><br>
        Use this option to safely exit the system.
    </li>
</ol>

<br>
<h3>Room Rates</h3>

<ul>
    <li>Standard Room – Rs. 5000 per night</li>
    <li>Deluxe Room – Rs. 8000 per night</li>
    <li>Suite Room – Rs. 12000 per night</li>
</ul>

<a class="back-link" href="<%= request.getContextPath() %>/jsp/dashboard.jsp">Back to Dashboard</a>

</div>

</body>
</html>