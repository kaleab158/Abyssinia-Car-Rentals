/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Controller.VehicleController;
import Model.Vehicle;
import DataBase.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kaleb
 */


public class VehicleDAO {
    Connection con = DBConnection.getConnection();
    // Add a new vehicle
    public void addVehicle(Vehicle v) {
        try {
            String sql = "INSERT INTO vehicle(model, plateNo, mileAge, dailyPrice, availability) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, v.getModel());
            ps.setString(2, v.getPlateNo());
            ps.setInt(3, v.getMileAge());
            ps.setDouble(4, v.getDailyPrice());
            ps.setString(5, v.getAvailability());
            ps.executeUpdate();
            System.out.println("Vehicle saved to DB!");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Update vehicle information
    public void updateVehicle(Vehicle vehicle) {
    String sql = "UPDATE Vehicle SET model=?, plateNo=?, mileage=?, dailyPrice=?, availability=? WHERE vehId=?";
    try (
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(sql)
    ) {
        pst.setString(1, vehicle.getModel());
        pst.setString(2, vehicle.getPlateNo());
        pst.setInt(3, vehicle.getMileAge());
        pst.setDouble(4, vehicle.getDailyPrice());
        pst.setString(5, vehicle.getAvailability());
        pst.setInt(6, vehicle.getVehId());
System.out.println("Vehicle ID = " + vehicle.getVehId());
        int rowsUpdated = pst.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Vehicle updated successfully!");
        } else {
            System.out.println("Vehicle not found!");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    // Remove vehicle by ID
    public void deleteVehicle(int vehicleId) {
      try {
          String sql = "DELETE FROM Vehicle WHERE vehId = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, vehicleId);
            pst.executeUpdate();
      }
      catch(Exception e){
            e.printStackTrace();
      }
    }

    // Get all vehicles
    public List<Vehicle> getAllVehicles() {

      List<Vehicle> vehicles = new ArrayList<>();

    String sql = "SELECT * FROM Vehicle"; 

    try (
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
    ) {

        while (rs.next()) {

            Vehicle v = new Vehicle();

            v.setVehId(rs.getInt("vehId"));
            v.setModel(rs.getString("model"));
            v.setPlateNo(rs.getString("plateNo"));
            v.setMileAge(rs.getInt("mileage"));
            v.setDailyPrice(rs.getDouble("dailyPrice"));
            v.setAvailability(rs.getString("availability"));

            vehicles.add(v);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return vehicles;
}
    
    public List<Vehicle> GetavilableVehicle(){
         List<Vehicle> vehicles = new ArrayList<>();

    String sql = "SELECT * FROM Vehicle WHERE availability = 'Available'";

    try (
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
    ) {

        while (rs.next()) {

            Vehicle v = new Vehicle();

            v.setVehId(rs.getInt("vehId"));
            v.setModel(rs.getString("model"));
            v.setPlateNo(rs.getString("plateNo"));
            v.setMileAge(rs.getInt("mileage"));
            v.setDailyPrice(rs.getDouble("dailyPrice"));
            v.setAvailability(rs.getString("availability"));

            vehicles.add(v);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return vehicles;
    }
  
    // Find vehicle by ID
   public Vehicle getVehicleById(int vehicleId) {

    Vehicle vehicle = null;

    String sql = "SELECT * FROM Vehicle WHERE vehId = ?";

    try (
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
    ) {

        pst.setInt(1, vehicleId);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {

            vehicle = new Vehicle();

            vehicle.setVehId(rs.getInt("vehId"));
            vehicle.setModel(rs.getString("model"));
            vehicle.setPlateNo(rs.getString("plateNo"));

            // ⚠️ make sure this matches DB column exactly
            vehicle.setMileAge(rs.getInt("mileage"));

            vehicle.setDailyPrice(rs.getDouble("dailyPrice"));
            vehicle.setAvailability(rs.getString("availability"));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return vehicle; // ✅ REQUIRE
}

   public List<Vehicle> getVehiclesByModel(String model) {

      List<Vehicle> list = new ArrayList<>();

    String sql = "SELECT vehId, model, plateNo, dailyPrice ,availability FROM Vehicle WHERE model LIKE ?";

    try (
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
    ) {

        pst.setString(1, "%" + model + "%");

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {

            Vehicle v = new Vehicle();

            v.setVehId(rs.getInt("vehId"));
            v.setModel(rs.getString("model"));
            v.setPlateNo(rs.getString("plateNo"));
            v.setDailyPrice(rs.getDouble("dailyPrice"));
            v.setAvailability(rs.getString("availability"));
            list.add(v);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;}
    // Search vehicle by model
 
    // Change availability
    public void updateAvailability(int vehicleId,
                                   String availability) {

    }
    public List<Vehicle> GetVehiclePrice(){
        
          ArrayList<Vehicle> vehicles = new ArrayList<>();

        String sql =
        "SELECT * FROM Vehicle WHERE availability = ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setString(1, "Available");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Vehicle vehicle = new Vehicle();

                vehicle.setVehId(
                        rs.getInt("vehId"));

                vehicle.setModel(
                        rs.getString("model"));

                vehicle.setPlateNo(
                        rs.getString("plateNo"));

                vehicle.setMileAge(
                        rs.getInt("mileAge"));

                vehicle.setDailyPrice(
                        rs.getDouble("dailyPrice"));

                vehicle.setAvailability(
                        rs.getString("availability"));

                vehicles.add(vehicle);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return vehicles;
    }
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
    public String getVehicleModel(int vehId) {

    String sql =
    "SELECT model FROM Vehicle WHERE vehId = ?";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement pst =
                con.prepareStatement(sql);

        pst.setInt(1, vehId);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {

            return rs.getString("model");

        }

    } catch (Exception e) {

        e.printStackTrace();

    }

    return "";
}
   public int getVehicleIdByModel(String model) {

    String sql = "SELECT vehId FROM Vehicle WHERE model = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setString(1, model);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return rs.getInt("vehId");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return -1;
}
 public int getTotalVehicles() {

    int total = 0;

    String sql = "SELECT COUNT(*) FROM Vehicle";

    try (
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
    ) {

        if (rs.next()) {
            total = rs.getInt(1);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return total;
}
 public void markVehicleAsAvailable(int vehId) {

    String sql = "UPDATE Vehicle SET availability = 'Available' WHERE vehId = ?";

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
