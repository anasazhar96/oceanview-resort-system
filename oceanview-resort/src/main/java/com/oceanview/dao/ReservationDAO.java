package com.oceanview.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oceanview.model.Reservation;

public class ReservationDAO {

    public boolean addReservation(Reservation reservation) {
        boolean status = false;

        String query = "INSERT INTO reservations (reservation_no, guest_id, room_type, check_in, check_out) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, reservation.getReservationNo());
            pst.setInt(2, reservation.getGuestId());
            pst.setString(3, reservation.getRoomType());
            pst.setDate(4, reservation.getCheckIn());
            pst.setDate(5, reservation.getCheckOut());

            int rows = pst.executeUpdate();
            status = rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public Map<String, Object> getReservationByNumber(String reservationNo) {
        Map<String, Object> reservationData = null;

        String query = "SELECT r.reservation_id, r.reservation_no, r.guest_id, r.room_type, r.check_in, r.check_out, "
                     + "g.guest_name, g.address, g.contact_number "
                     + "FROM reservations r "
                     + "JOIN guests g ON r.guest_id = g.guest_id "
                     + "WHERE r.reservation_no = ?";

        try {
            Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, reservationNo);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                reservationData = new HashMap<>();

                Reservation reservation = new Reservation();
                reservation.setReservationId(rs.getInt("reservation_id"));
                reservation.setReservationNo(rs.getString("reservation_no"));
                reservation.setGuestId(rs.getInt("guest_id"));
                reservation.setRoomType(rs.getString("room_type"));
                reservation.setCheckIn(rs.getDate("check_in"));
                reservation.setCheckOut(rs.getDate("check_out"));

                reservationData.put("reservation", reservation);
                reservationData.put("guestName", rs.getString("guest_name"));
                reservationData.put("address", rs.getString("address"));
                reservationData.put("contactNumber", rs.getString("contact_number"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return reservationData;
    }
    
    public String generateReservationNumber() {

        String newReservationNo = "R001";

        String query = "SELECT reservation_no FROM reservations ORDER BY reservation_id DESC LIMIT 1";

        try {
            Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String lastReservationNo = rs.getString("reservation_no");

                int number = Integer.parseInt(lastReservationNo.substring(1));
                number++;

                newReservationNo = String.format("R%03d", number);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return newReservationNo;
    }

    public List<Map<String, Object>> getAllReservations() {
        List<Map<String, Object>> reservationList = new ArrayList<>();

        String query = "SELECT r.reservation_id, r.reservation_no, r.guest_id, r.room_type, r.check_in, r.check_out, "
                     + "g.guest_name, g.address, g.contact_number "
                     + "FROM reservations r "
                     + "JOIN guests g ON r.guest_id = g.guest_id "
                     + "ORDER BY r.reservation_id DESC";

        try {
            Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Map<String, Object> reservationData = new HashMap<>();

                Reservation reservation = new Reservation();
                reservation.setReservationId(rs.getInt("reservation_id"));
                reservation.setReservationNo(rs.getString("reservation_no"));
                reservation.setGuestId(rs.getInt("guest_id"));
                reservation.setRoomType(rs.getString("room_type"));
                reservation.setCheckIn(rs.getDate("check_in"));
                reservation.setCheckOut(rs.getDate("check_out"));

                reservationData.put("reservation", reservation);
                reservationData.put("guestName", rs.getString("guest_name"));
                reservationData.put("address", rs.getString("address"));
                reservationData.put("contactNumber", rs.getString("contact_number"));

                reservationList.add(reservationData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return reservationList;
    }
}