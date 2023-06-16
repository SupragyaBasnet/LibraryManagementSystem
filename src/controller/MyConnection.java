/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.sql.*;

/**
 *
 * 
 */
public class MyConnection {
    public static Connection dbconnect() {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3307/app?user=root&password=bibhaktadon123");
            //System.out.println("connected to database");
            return conn;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
