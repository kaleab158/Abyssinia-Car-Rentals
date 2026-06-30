/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DataBase.DBConnection;
import Model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kaleb
 */
public class CustomerDAO {
   public void register(Customer c) {

    String sql =
        "INSERT INTO customer (user_id, first_name, last_name, city, country, house_number, contact_number, license_no) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setInt(1, c.getUserId());
        pst.setString(2, c.getFirstName());
        pst.setString(3, c.getLastName());
        pst.setString(4, c.getCity());
        pst.setString(5, c.getCountry());
        pst.setString(6, c.getHouseNumber());
        pst.setString(7, c.getContactNumber()); // ✅
        pst.setString(8, c.getLicenseNumber()); // ✅

        pst.executeUpdate();

        System.out.println("Customer registered successfully!");

    } catch (Exception e) {
        e.printStackTrace();
    }
}
   public List<Customer> getAllCustomers() {

    List<Customer> customers = new ArrayList<>();

    String sql = "SELECT * FROM Customer";

    try (
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
    ) {

        while (rs.next()) {

            Customer c = new Customer();

            c.setCustomerId(
                    rs.getInt("customer_id"));

            c.setUserId(
                    rs.getInt("user_id"));

            c.setFirstName(
                    rs.getString("first_name"));

            c.setLastName(
                    rs.getString("last_name"));

            c.setCity(
                    rs.getString("city"));

            c.setCountry(
                    rs.getString("country"));

            c.setHouseNumber(
                    rs.getString("house_number"));

            c.setContactNumber(
                    rs.getString("contact_number"));

            c.setLicenseNumber(
                    rs.getString("license_no"));

            customers.add(c);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return customers;
}
   public int getTotalCustomers() {

    int total = 0;

    String sql = "SELECT COUNT(*) FROM Customer";

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
}

