package com.oceanview.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.oceanview.model.Reservation;
import com.oceanview.service.BillingService;

import java.sql.Date;

public class BillingServiceTest {

    @Test
    void testCalculateBillStandardRoom() {

        Reservation reservation = new Reservation();
        reservation.setRoomType("Standard");
        reservation.setCheckIn(Date.valueOf("2025-07-10"));
        reservation.setCheckOut(Date.valueOf("2025-07-12"));

        BillingService billingService = new BillingService();

        double bill = billingService.calculateBill(reservation);

        assertEquals(10000.0, bill);
    }

    @Test
    void testCalculateBillDeluxeRoom() {

        Reservation reservation = new Reservation();
        reservation.setRoomType("Deluxe");
        reservation.setCheckIn(Date.valueOf("2025-07-10"));
        reservation.setCheckOut(Date.valueOf("2025-07-12"));

        BillingService billingService = new BillingService();

        double bill = billingService.calculateBill(reservation);

        assertEquals(16000.0, bill);
    }

    @Test
    void testCalculateBillSuiteRoom() {

        Reservation reservation = new Reservation();
        reservation.setRoomType("Suite");
        reservation.setCheckIn(Date.valueOf("2025-07-10"));
        reservation.setCheckOut(Date.valueOf("2025-07-12"));

        BillingService billingService = new BillingService();

        double bill = billingService.calculateBill(reservation);

        assertEquals(24000.0, bill);
    }
}