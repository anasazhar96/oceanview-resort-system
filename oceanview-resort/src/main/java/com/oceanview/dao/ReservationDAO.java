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
    public Reservation getReservationByNumber(String reservationNo) {
        Reservation reservation = null;

        String sql = "SELECT * FROM reservations WHERE reservation_no = ?";

        try (Connection con = DBConnection.getInstance().getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, reservationNo);

            try (java.sql.ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    reservation = new Reservation();
                    reservation.setReservationId(rs.getInt("reservation_id"));
                    reservation.setReservationNo(rs.getString("reservation_no"));
                    reservation.setGuestName(rs.getString("guest_name"));
                    reservation.setAddress(rs.getString("address"));
                    reservation.setContactNumber(rs.getString("contact_number"));
                    reservation.setRoomType(rs.getString("room_type"));
                    reservation.setCheckIn(rs.getDate("check_in"));
                    reservation.setCheckOut(rs.getDate("check_out"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return reservation;
    }
}