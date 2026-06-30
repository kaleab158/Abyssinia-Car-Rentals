package DAO;

import DataBase.DBConnection;
import Model.Employee;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {


  public int registerUser(User u) {


    int userId = -1;

    String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        pst.setString(1, u.getUsername());
        pst.setString(2, u.getPassword()); // later you can hash it
        pst.setString(3, u.getRole());

        pst.executeUpdate();

        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            userId = rs.getInt(1);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return userId;
}

    public User login(String username, String password) {


    String sql = "SELECT * FROM users WHERE username=? AND password =?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(sql)) {

        pst.setString(1, username);
        pst.setString(2, password);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {

            User u = new User();
            u.setUserId(rs.getInt("id"));
            u.setUsername(rs.getString("username"));
            u.setRole(rs.getString("role"));

            return u;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}

    
}