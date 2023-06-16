/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;
import model.*;
import view.LoginView;
import view.RegisterView;
/**
 *
 * 
 */
public class RegisterController {
    RegisterModel model;
    RegisterView view;
    ResultSet rs;
    PreparedStatement pst=null;
    public RegisterController(RegisterView view)
        {
            this.view=view;
            
             view.addRegisterListner(new RegisterListener());
        }
    
        class RegisterListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            try
            {
                model=view.getUser();
                if(checkUser(model))
                {
                    view.setMessage("Registered Successfully");
                    this.dispose();
                    LoginView loginPage = new LoginView();
                    loginPage.setVisible(true); 
                }
            }
            catch(Exception e1)
            {
                
            }

        }
       
        public boolean checkUser(RegisterModel user) throws Exception
        {
           
        try
          {
         Class.forName("com.mysql.cj.jdbc.Driver");
               Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/app","root","bibhaktadon123");
String sql="insert into registration(username,firstname,lastname,gmail,phonenum,food,password,confirmpassword) values(?,?,?,?,?,?,?,?)";
pst = conn.prepareStatement(sql);

// String sql="select * from patient where pname='"+user.getUsername()+"' AND paddress='"+user.getPassword()+"'";
pst.setString(1,user.getUsername());
pst.setString(2,user.getFirstname());
pst.setString(3,user.getLastname());
pst.setString(4,user.getGmail());
pst.setString(5,user.getPhonenum());
pst.setString(6,user.getFood());
pst.setString(7,user.getPassword());
pst.setString(8,user.getConfirmpassword());



pst.executeUpdate();
         System.out.println("Data inserted");
JOptionPane.showMessageDialog(null,"Data Registered Successfully");
          
          }
          catch(SQLException e2)
          {
              System.out.println(e2.getMessage());
          }         
            
            return false;
        }

        private void dispose() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    
}

    
    
}