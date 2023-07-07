/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Bibhakta lamsal
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.RegisterModel;

public class AddregisterDao {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3307/app";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "bibhaktadon123";

    public boolean addUser(RegisterModel user) {
        try (Connection conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
             PreparedStatement pst = conn.prepareStatement("INSERT INTO registration(username, firstname, lastname, gmail, phonenum, food, password, confirmpassword) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {

            pst.setString(1, user.getUsername());
            pst.setString(2, user.getFirstname());
            pst.setString(3, user.getLastname());
            pst.setString(4, user.getGmail());
            pst.setString(5, user.getPhonenum());
            pst.setString(6, user.getFood());
            pst.setString(7, user.getPassword());
            pst.setString(8, user.getConfirmpassword());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Registered Successfully");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

