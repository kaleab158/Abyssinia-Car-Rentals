/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataBase.DBConnection;
import Model.Reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kaleb
 */
public class ReservationDAO {
    public void reserveVehicle(int customerId, int vehId, String reserveDate, String returnDate) {

    String sql = "INSERT INTO Reservation(customerId, vehId, reserveDate, returnDate, status) VALUES (?, ?, ?, ?, ?)";

    try (
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
    ) {

        pst.setInt(1, customerId);
        pst.setInt(2, vehId);
        pst.setString(3, reserveDate);
        pst.setString(4, returnDate);
        pst.setString(5, "Not Avilable");

        pst.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }
}


//public void markVehicleAsAvailable(int vehId) {
//
//    String sql =
//    "UPDATE Vehicle SET availability = 'Available' WHERE vehId = ?";
//
//    try (
//        Connection con = DBConnection.getConnection();
//        PreparedStatement pst = con.prepareStatement(sql);
//    ) {
//
//        pst.setInt(1, vehId);
//        pst.executeUpdate();
//
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//}
    
 public void markVehicleAsReserved(int vehId) {

    String sql = "UPDATE Vehicle SET availability = 'Not Available' WHERE vehId = ?";

    try (
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
    ) {

        pst.setInt(1, vehId);
        pst.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public List<Reservation> getAllReservations() {

    List<Reservation> list = new ArrayList<>();

    String sql = "SELECT * FROM Reservation";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {

            Reservation r = new Reservation();

            r.setReservationId(rs.getInt("reservationId"));
            r.setCustomerId(rs.getInt("customerId"));
            r.setVehId(rs.getInt("vehId"));
            r.setReserveDate(rs.getDate("reserveDate"));
            r.setReturnDate(rs.getDate("returnDate"));

            list.add(r);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}
    public List<Reservation> getReservationsByCustomerId(int customerId) {

    List<Reservation> list = new ArrayList<>();

    String sql =
    "SELECT * FROM Reservation WHERE customerId = ?";

    try (
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
    ) {

        pst.setInt(1, customerId);

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {

            Reservation r = new Reservation();

            r.setReservationId(
                    rs.getInt("reservationId"));

            r.setCustomerId(
                    rs.getInt("customerId"));

            r.setVehId(
                    rs.getInt("vehId"));

            r.setReserveDate(
                    rs.getDate("reserveDate"));

            r.setReturnDate(
                    rs.getDate("returnDate"));

            list.add(r);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}
   public void cancelReservationByVehId(int vehId) {

    String sql =
        "UPDATE Reservation " +
        "SET status = 'Avilable' " +
        "WHERE vehId = ?";

    try (
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
    ) {

        pst.setInt(1, vehId);
        pst.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}   
