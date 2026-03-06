package com.oceanview.controller;

import java.io.IOException;

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
        Reservation reservation = reservationService.getReservationByNumber(reservationNo);

        double totalBill = 0.0;

        if (reservation != null) {
            BillingService billingService = new BillingService();
            totalBill = billingService.calculateBill(reservation);
        }

        request.setAttribute("reservation", reservation);
        request.setAttribute("totalBill", totalBill);

        request.getRequestDispatcher("/jsp/calculateBill.jsp").forward(request, response);
    }
}