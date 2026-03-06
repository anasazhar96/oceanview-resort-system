package com.oceanview.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oceanview.service.ReservationService;

@WebServlet("/viewReservation")
public class ViewReservationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String reservationNo = request.getParameter("reservationNo");

        ReservationService service = new ReservationService();
        Map<String, Object> reservationData = service.getReservationByNumber(reservationNo);

        if (reservationData != null) {
            request.setAttribute("reservation", reservationData.get("reservation"));
            request.setAttribute("guestName", reservationData.get("guestName"));
            request.setAttribute("address", reservationData.get("address"));
            request.setAttribute("contactNumber", reservationData.get("contactNumber"));
        } else {
            request.setAttribute("errorMessage", "Reservation not found.");
        }

        request.getRequestDispatcher("/jsp/viewReservation.jsp").forward(request, response);
    }
}