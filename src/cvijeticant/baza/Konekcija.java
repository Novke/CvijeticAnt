/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvijeticant.baza;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Novica
 */
public class Konekcija {
    
    Connection connection = null;
    
    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/stdentska_sluzba";
            String user = "root";
            String pass = "";
            
            connection = DriverManager.getConnection(url, user, pass);
            
        }catch(Exception e){
           e.printStackTrace();
            System.err.println("Greska u konekciji");
        }
    }
    
    public void disconnect(){
        try {
            if (connection!=null) connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
    
}
