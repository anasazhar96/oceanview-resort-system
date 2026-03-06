package com.oceanview.service;

import java.util.List;
import java.util.Map;

import com.oceanview.dao.ReservationDAO;
import com.oceanview.model.Reservation;

public class ReservationService {

    private ReservationDAO reservationDAO;

    public ReservationService() {
        this.reservationDAO = new ReservationDAO();
    }

    public boolean addReservation(Reservation reservation) {

        if (reservation == null) {
            return false;
        }

        if (reservation.getReservationNo() == null || reservation.getReservationNo().trim().isEmpty()) {
            return false;
        }

        if (reservation.getGuestId() <= 0) {
            return false;
        }

        if (reservation.getRoomType() == null || reservation.getRoomType().trim().isEmpty()) {
            return false;
        }

        if (reservation.getCheckIn() == null || reservation.getCheckOut() == null) {
            return false;
        }

        if (reservation.getCheckOut().before(reservation.getCheckIn())) {
            return false;
        }

        return reservationDAO.addReservation(reservation);
    }

    public Map<String, Object> getReservationByNumber(String reservationNo) {

        if (reservationNo == null || reservationNo.trim().isEmpty()) {
            return null;
        }

        return reservationDAO.getReservationByNumber(reservationNo);
    }

    public List<Map<String, Object>> getAllReservations() {
        return reservationDAO.getAllReservations();
    }
}