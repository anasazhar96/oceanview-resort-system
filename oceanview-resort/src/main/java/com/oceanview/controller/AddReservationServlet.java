package com.oceanview.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oceanview.service.ReservationService;
import com.oceanview.model.Reservation;

@WebServlet("/addReservation")
public class AddReservationServlet extends HttpServlet {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String reservationNo = request.getParameter("reservationNo");
        String guestName = request.getParameter("guestName");
        String address = request.getParameter("address");
        String contactNumber = request.getParameter("contactNumber");
        String roomType = request.getParameter("roomType");
        Date checkIn = Date.valueOf(request.getParameter("checkIn"));
        Date checkOut = Date.valueOf(request.getParameter("checkOut"));

        Reservation reservation = new Reservation();
        reservation.setReservationNo(reservationNo);
        reservation.setGuestName(guestName);
        reservation.setAddress(address);
        reservation.setContactNumber(contactNumber);
        reservation.setRoomType(roomType);
        reservation.setCheckIn(checkIn);
        reservation.setCheckOut(checkOut);

        ReservationService service = new ReservationService();

        if (service.addReservation(reservation)) {
            response.sendRedirect("jsp/dashboard.jsp?success=true");
        } else {
            response.sendRedirect("jsp/dashboard.jsp?error=true");
        }
    }
}