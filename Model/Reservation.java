/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author kaleb
 */


import java.sql.Date;


public class Reservation {

    private int reservationId;
    private int customerId;
    private int vehId;
    private Date reserveDate;
    private Date returnDate;

    // EMPTY CONSTRUCTOR
    public Reservation() {
    }

    // FULL CONSTRUCTOR (optional but useful)
    public Reservation(int reservationId, int customerId, int vehId, Date reserveDate, Date returnDate) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.vehId = vehId;
        this.reserveDate = reserveDate;
        this.returnDate = returnDate;
    }

    // GETTERS AND SETTERS

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getVehId() {
        return vehId;
    }

    public void setVehId(int vehId) {
        this.vehId = vehId;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}