<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Reservation</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>

<div class="container">

    <h2>Add New Reservation</h2>

    <form action="<%= request.getContextPath() %>/addReservation" method="post">

        <label>Guest Name:</label><br>
        <input type="text" name="guestName" placeholder="Enter guest name" required><br><br>

        <label>Address:</label><br>
        <textarea name="address" placeholder="Enter address" required></textarea><br><br>

        <label>Contact Number:</label><br>
        <input type="text" name="contactNumber" placeholder="Enter contact number" pattern="[0-9]{10}" title="Enter a 10-digit contact number" required><br><br>

        <label>Room Type:</label><br>
        <select name="roomType" required>
            <option value="">-- Select Room Type --</option>
            <option value="Standard">Standard</option>
            <option value="Deluxe">Deluxe</option>
            <option value="Suite">Suite</option>
        </select><br><br>

        <label>Check-In Date:</label><br>
        <input type="date" name="checkIn" id="checkIn" required><br><br>

        <label>Check-Out Date:</label><br>
        <input type="date" name="checkOut" id="checkOut" required><br><br>

        <button type="submit">Add Reservation</button>
		<button type="reset">Reset</button>
		
		<br><br>
		
		<a href="<%= request.getContextPath() %>/jsp/dashboard.jsp">
		<button type="button">Back to Dashboard</button>
		</a>
    </form>
    
<script>

const checkIn = document.getElementById("checkIn");
const checkOut = document.getElementById("checkOut");

checkIn.addEventListener("change", function() {
    checkOut.min = checkIn.value;
});

const today = new Date().toISOString().split("T")[0];
checkIn.min = today;

</script>
    
</div>

</body>
</html>