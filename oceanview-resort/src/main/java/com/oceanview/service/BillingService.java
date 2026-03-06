package com.oceanview.service;

import com.oceanview.model.Reservation;
import java.time.temporal.ChronoUnit;

public class BillingService {

    public double calculateBill(Reservation reservation) {

        if (reservation == null) {
            return 0.0;
        }

        if (reservation.getCheckIn() == null || reservation.getCheckOut() == null) {
            return 0.0;
        }

        long nights = ChronoUnit.DAYS.between(
                reservation.getCheckIn().toLocalDate(),
                reservation.getCheckOut().toLocalDate()
        );

        if (nights <= 0) {
            return 0.0;
        }

        double roomRate = getRoomRate(reservation.getRoomType());

        return nights * roomRate;
    }

    private double getRoomRate(String roomType) {

        if (roomType == null) {
            return 0.0;
        }

        switch (roomType) {
            case "Standard":
                return 5000.0;

            case "Deluxe":
                return 8000.0;

            case "Suite":
                return 12000.0;

            default:
                return 0.0;
        }
    }
}