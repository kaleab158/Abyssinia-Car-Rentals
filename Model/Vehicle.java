/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author kaleb
 */


public class Vehicle {

    private int vehId;
    private String model;
    private String plateNo;
    private int mileAge;
    private double dailyPrice;
    private String availability; // Available, Reserved

    // Default Constructor
    public Vehicle() {
    }

    // Parameterized Constructor
    public Vehicle(int vehId, String model, String plateNo,
                   int mileAge, double dailyPrice,
                   String availability) {

        this.vehId = vehId;
        this.model = model;
        this.plateNo = plateNo;
        this.mileAge = mileAge;
        this.dailyPrice = dailyPrice;
        this.availability = availability;
    }

    // Get Vehicle ID
    public int getVehId() {
        return vehId;
    }

    // Set Vehicle ID
    public void setVehId(int vehId) {
        this.vehId = vehId;
    }

    // Get Model
    public String getModel() {
        return model;
    }

    // Set Model
    public void setModel(String model) {
        this.model = model;
    }

    // Get Plate Number
    public String getPlateNo() {
        return plateNo;
    }

    // Set Plate Number
    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    // Get Mileage
    public int getMileAge() {
        return mileAge;
    }

    // Set Mileage
    public void setMileAge(int mileAge) {
        this.mileAge = mileAge;
    }

    // Get Daily Price
    public double getDailyPrice() {
        return dailyPrice;
    }

    // Set Daily Price
    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    // Get Availability
    public String getAvailability() {
        return availability;
    }

    // Set Availability
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehId=" + vehId +
                ", model='" + model + '\'' +
                ", plateNo='" + plateNo + '\'' +
                ", mileAge=" + mileAge +
                ", dailyPrice=" + dailyPrice +
                ", availability='" + availability + '\'' +
                '}';
    }
}