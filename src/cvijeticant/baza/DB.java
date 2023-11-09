/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvijeticant.baza;

import cvijeticant.domen.Zvanje;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Novica
 */
public class DB {
    
    Connection connection;
    
    public List<Zvanje> getAllZvanja(){
        List<Zvanje> vrati = new ArrayList<>();
        Konekcija konekcija = new Konekcija();
        try {
        
        konekcija.connect();
        
        Connection connection = konekcija.getConnection();
        
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM zvanje";
        
        ResultSet rs = statement.executeQuery(query);
        
        while (rs.next()){
            int id = rs.getInt("id");
            String naziv = rs.getString("naziv");
            Zvanje zvanje = new Zvanje(id, naziv);
            vrati.add(zvanje);
        }
        
        
        return vrati;
        } catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            konekcija.disconnect();
        }
    }
    
}
