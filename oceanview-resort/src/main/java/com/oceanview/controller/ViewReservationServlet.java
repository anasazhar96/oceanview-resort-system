package com.oceanview.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oceanview.model.Reservation;
import com.oceanview.service.ReservationService;

@WebServlet("/viewReservation")
public class ViewReservationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String reservationNo = request.getParameter("reservationNo");

        ReservationService service = new ReservationService();
        Reservation reservation = service.getReservationByNumber(reservationNo);

        request.setAttribute("reservation", reservation);

        request.getRequestDispatcher("/jsp/viewReservation.jsp").forward(request, response);
    }
}