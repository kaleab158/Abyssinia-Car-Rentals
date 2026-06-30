/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.VehicleDAO;
import DAO.ReservationDAO;
import Model.Reservation;
import java.util.List;

import java.util.List;
import DAO.ReservationDAO;

public class ReservationController {

    private ReservationDAO dao = new ReservationDAO();

    // GET ALL RESERVATIONS
    public List<Reservation> getAllReservations() {
        return dao.getAllReservations();
    }
public void cancelReservationByVehId(int vehId) {

    ReservationDAO reservationDAO = new ReservationDAO();
    VehicleDAO vehicleDAO = new VehicleDAO();

    reservationDAO.cancelReservationByVehId(vehId);
    vehicleDAO.markVehicleAsAvailable(vehId);
}

    public void reserveVehicle(int customerId, int vehId, String reserveDate, String returnDate) {
        dao.reserveVehicle(customerId, vehId, reserveDate, returnDate);
        dao.markVehicleAsReserved(vehId);
    }
    public List<Reservation> getReservationsByCustomerId(int customerId) {
    return dao.getReservationsByCustomerId(customerId);

}}