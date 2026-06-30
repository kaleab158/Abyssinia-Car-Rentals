/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Vehicle;
import DAO.VehicleDAO;
import DAO.ReservationDAO;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author kaleb
 */
public class VehicleController {

    private VehicleDAO vehicleDAO = new VehicleDAO();

    public void addVehicle(Vehicle v) {
        vehicleDAO.addVehicle(v);
        System.out.println("Vehicle added successfully: " + v.getModel());
    }
    public void deleteVehicle(int VehiclID){
         vehicleDAO.deleteVehicle(VehiclID);
          System.out.println("Vehicle Deleted Succesfully");
    }
    public void updateVehicle(Vehicle v){
       vehicleDAO.updateVehicle(v);
       System.out.println("Vehicle Updated Succesfully");
    }
    public List<Vehicle> GetVehiclePrice(){         
        return vehicleDAO.getAllVehicles();
    }

 public Vehicle getVehicleById(int vehicleId) {
    return vehicleDAO.getVehicleById(vehicleId);

}
 public List<Vehicle> getAllVehicles(){
    return vehicleDAO.getAllVehicles();
}
  public List<Vehicle> GetavilableVehicle(){
    return vehicleDAO.GetavilableVehicle();
}
 
 public List<Vehicle> getVehiclesByModel(String model) {
    return vehicleDAO.getVehiclesByModel(model);
}
    public void reserveVehicle(int customerId, int vehId, String reserveDate, String returnDate) {
        vehicleDAO.markVehicleAsReserved(vehId);
    }
    public int getTotalVehicles() {
    return vehicleDAO.getTotalVehicles();
}
    
}
