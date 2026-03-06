<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Reservation</title>
</head>
<body>

    <h2>Add New Reservation</h2>

    <form action="<%= request.getContextPath() %>/addReservation" method="post">

        <label>Guest Name:</label><br>
        <input type="text" name="guestName" required><br><br>

        <label>Address:</label><br>
        <textarea name="address" required></textarea><br><br>

        <label>Contact Number:</label><br>
        <input type="text" name="contactNumber" required><br><br>

        <label>Room Type:</label><br>
        <select name="roomType" required>
            <option value="">-- Select Room Type --</option>
            <option value="Standard">Standard</option>
            <option value="Deluxe">Deluxe</option>
            <option value="Suite">Suite</option>
        </select><br><br>

        <label>Check-In Date:</label><br>
        <input type="date" name="checkIn" required><br><br>

        <label>Check-Out Date:</label><br>
        <input type="date" name="checkOut" required><br><br>

        <button type="submit">Add Reservation</button>
    </form>

</body>
</html>