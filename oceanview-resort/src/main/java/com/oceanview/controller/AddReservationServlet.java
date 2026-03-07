package com.oceanview.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oceanview.dao.GuestDAO;
import com.oceanview.dao.ReservationDAO;
import com.oceanview.model.Guest;
import com.oceanview.model.Reservation;
import com.oceanview.service.ReservationService;

@WebServlet("/addReservation")
public class AddReservationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            ReservationDAO reservationDAO = new ReservationDAO();
            String reservationNo = reservationDAO.generateReservationNumber();

            String guestName = request.getParameter("guestName");
            String address = request.getParameter("address");
            String contactNumber = request.getParameter("contactNumber");
            String roomType = request.getParameter("roomType");

            Date checkIn = Date.valueOf(request.getParameter("checkIn"));
            Date checkOut = Date.valueOf(request.getParameter("checkOut"));

            Guest guest = new Guest();
            guest.setGuestName(guestName);
            guest.setAddress(address);
            guest.setContactNumber(contactNumber);

            GuestDAO guestDAO = new GuestDAO();
            int guestId = guestDAO.addGuest(guest);

            if (guestId <= 0) {
                response.sendRedirect("jsp/dashboard.jsp?error=true");
                return;
            }

            Reservation reservation = new Reservation();
            reservation.setReservationNo(reservationNo);
            reservation.setGuestId(guestId);
            reservation.setRoomType(roomType);
            reservation.setCheckIn(checkIn);
            reservation.setCheckOut(checkOut);

            ReservationService service = new ReservationService();

            if (service.addReservation(reservation)) {
                response.sendRedirect("jsp/dashboard.jsp?success=true&resNo=" + reservationNo);
            } else {
                response.sendRedirect("jsp/dashboard.jsp?error=true");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("jsp/dashboard.jsp?error=true");
        }
    }
}