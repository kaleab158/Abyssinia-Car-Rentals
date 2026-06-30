/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.CustomerDAO;
import Model.Customer;
import java.util.List;

/**
 *
 * @author kaleb
 */
public class CustomerController {
    private CustomerDAO dao = new CustomerDAO();
    public List<Customer> getAllCustomers() {
    return dao.getAllCustomers();
}
    public int getTotalCustomers() {
    return dao.getTotalCustomers();
}
}
