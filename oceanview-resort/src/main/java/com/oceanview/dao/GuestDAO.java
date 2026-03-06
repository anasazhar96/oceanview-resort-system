package com.oceanview.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.oceanview.model.Guest;

public class GuestDAO {

    public int addGuest(Guest guest) {
        int guestId = -1;

        String query = "INSERT INTO guests (guest_name, address, contact_number) VALUES (?, ?, ?)";

        try {
            Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement pst = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            pst.setString(1, guest.getGuestName());
            pst.setString(2, guest.getAddress());
            pst.setString(3, guest.getContactNumber());

            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                guestId = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return guestId;
    }
}