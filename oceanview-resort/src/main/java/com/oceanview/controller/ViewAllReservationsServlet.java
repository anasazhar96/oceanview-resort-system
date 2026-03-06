package com.oceanview.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oceanview.service.ReservationService;

@WebServlet("/viewAllReservations")
public class ViewAllReservationsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ReservationService service = new ReservationService();

        List<Map<String, Object>> reservations = service.getAllReservations();

        request.setAttribute("reservations", reservations);

        request.getRequestDispatcher("/jsp/viewAllReservations.jsp").forward(request, response);
    }
}