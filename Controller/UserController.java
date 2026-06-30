/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.CustomerDAO;
import DAO.EmployeeDAO;
import DAO.UserDAO;
import Model.Customer;
import Model.Employee;
import Model.User;

/**
 *
 * @author kaleb
 */
public class UserController {

    UserDAO userDAO = new UserDAO();
    CustomerDAO customerDAO = new CustomerDAO();
    EmployeeDAO employeeDAO = new EmployeeDAO();

    public int registerUser(User u) {
        return userDAO.registerUser(u);
    }

    public User login(String u, String p) {
        return userDAO.login(u, p);
    }

    public void registerCustomer(Customer c) {
        customerDAO.register(c);
    }

    public void registerEmployee(Employee e) {
        employeeDAO.register(e);
    }
}
