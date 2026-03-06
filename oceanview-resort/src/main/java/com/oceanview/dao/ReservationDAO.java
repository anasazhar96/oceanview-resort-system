package com.oceanview.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.oceanview.model.Reservation;

public class ReservationDAO {

    public boolean addReservation(Reservation reservation) {
        boolean rowInserted = false;

        String sql = "INSERT INTO reservations "
                + "(reservation_no, guest_name, address, contact_number, room_type, check_in, check_out) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, reservation.getReservationNo());
            ps.setString(2, reservation.getGuestName());
            ps.setString(3, reservation.getAddress());
            ps.setString(4, reservation.getContactNumber());
            ps.setString(5, reservation.getRoomType());
            ps.setDate(6, reservation.getCheckIn());
            ps.setDate(7, reservation.getCheckOut());

            rowInserted = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowInserted;
    }
}