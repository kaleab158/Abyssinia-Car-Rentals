/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataBase.DBConnection;
import Model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author kaleb
 */
public class EmployeeDAO {


    public void register(Employee e) {

    String sql =
        "INSERT INTO employee (user_id, first_name, last_name, city, country, house_number, salary, contact_number) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setInt(1, e.getUserId());
        pst.setString(2, e.getFirstName());
        pst.setString(3, e.getLastName());
        pst.setString(4, e.getCity());
        pst.setString(5, e.getCountry());
        pst.setString(6, e.getHouseNumber());
        pst.setDouble(7, e.getSalary());
        pst.setString(8, e.getContactNumber());

        pst.executeUpdate();

        System.out.println("Employee registered successfully!");

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
}

