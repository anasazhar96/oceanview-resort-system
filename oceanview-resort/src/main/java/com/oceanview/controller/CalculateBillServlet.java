package com.oceanview.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oceanview.model.Reservation;
import com.oceanview.service.BillingService;
import com.oceanview.service.ReservationService;

@WebServlet("/calculateBill")
public class CalculateBillServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String reservationNo = request.getParameter("reservationNo");

        ReservationService reservationService = new ReservationService();
        Map<String, Object> reservationData = reservationService.getReservationByNumber(reservationNo);

        Reservation reservation = null;
        double totalBill = 0.0;

        if (reservationData != null) {
            reservation = (Reservation) reservationData.get("reservation");

            BillingService billingService = new BillingService();
            totalBill = billingService.calculateBill(reservation);

            request.setAttribute("guestName", reservationData.get("guestName"));
            request.setAttribute("address", reservationData.get("address"));
            request.setAttribute("contactNumber", reservationData.get("contactNumber"));
        } else {
            request.setAttribute("errorMessage", "Reservation not found.");
        }

        request.setAttribute("reservation", reservation);
        request.setAttribute("totalBill", totalBill);

        request.getRequestDispatcher("/jsp/calculateBill.jsp").forward(request, response);
    }
}