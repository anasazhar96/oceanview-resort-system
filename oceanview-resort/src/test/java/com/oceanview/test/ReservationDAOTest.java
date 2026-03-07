package com.oceanview.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import com.oceanview.model.Reservation;

import com.oceanview.dao.ReservationDAO;

public class ReservationDAOTest {

    @Test
    void testGetReservationByNumber() {

        ReservationDAO dao = new ReservationDAO();

        Map<String, Object> result = dao.getReservationByNumber("R001");

        assertNotNull(result);

    }
    @Test
    void testGetAllReservations() {

        ReservationDAO dao = new ReservationDAO();

        var reservations = dao.getAllReservations();

        assertNotNull(reservations);

    }
    @Test
    void testGenerateReservationNumber() {

        ReservationDAO dao = new ReservationDAO();

        String reservationNo = dao.generateReservationNumber();

        assertNotNull(reservationNo);
        assertTrue(reservationNo.startsWith("R"));

    }
    @Test
    void testAddReservation() {

        ReservationDAO dao = new ReservationDAO();

        Reservation reservation = new Reservation();
        reservation.setReservationNo("R999");
        reservation.setGuestId(1); 
        reservation.setRoomType("Standard");
        reservation.setCheckIn(java.sql.Date.valueOf("2025-07-10"));
        reservation.setCheckOut(java.sql.Date.valueOf("2025-07-12"));

        boolean result = dao.addReservation(reservation);

        assertTrue(result);

    }

}

