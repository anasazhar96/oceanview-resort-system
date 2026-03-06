package com.oceanview.service;

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

        if (reservation.getGuestName() == null || reservation.getGuestName().trim().isEmpty()) {
            return false;
        }

        if (reservation.getAddress() == null || reservation.getAddress().trim().isEmpty()) {
            return false;
        }

        if (reservation.getContactNumber() == null || reservation.getContactNumber().trim().isEmpty()) {
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
    
    public Reservation getReservationByNumber(String reservationNo) {

        if (reservationNo == null || reservationNo.trim().isEmpty()) {
            return null;
        }

        return reservationDAO.getReservationByNumber(reservationNo);
    }
}

