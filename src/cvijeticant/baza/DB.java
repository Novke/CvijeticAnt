/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvijeticant.baza;

import cvijeticant.domen.Nastavnik;
import cvijeticant.domen.Zvanje;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void saveNastavnik(Nastavnik nastavnik) throws SQLException {
        Konekcija konekcija =new Konekcija();
        try {
            konekcija.connect();
            Connection connection = konekcija.getConnection();
            
            
            
            
            
//////////////////////////////////   1    NACIN      ////////////////////////////////////            
//            Statement statement = connection.createStatement();
//            String query = "INSERT INTO nastavnik (id, ime, prezime, zvanje_id) VALUES " +
//                      "(" + nastavnik.getId() + ", '" + nastavnik.getIme() + "', '" + nastavnik.getPrezime() + "', " + nastavnik.getZvanje().getId() + ")";
/////////////////////////////////     2   NACIN     //////////////////////////////////////
            String query = "INSERT INTO nastavnik (id, ime, prezime, zvanje_id) VALUES (?, ?, ?, ?);";
            System.out.println(query);
                
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setInt(1, nastavnik.getId());
            ps.setString(2, nastavnik.getIme());
            ps.setString(3, nastavnik.getPrezime());
            ps.setInt(4, nastavnik.getZvanje().getId());
///////////////////////////////////////////////////////////////////////////////////// 
            
            
            
/////////////////////////////////   1 NACIN    ///////////////////////////////////////// 
            ps.execute();
////////////////////////////////     @ NACIN    ////////////////////////////////////// 
//            int x = statement.executeUpdate(query);
//            if (x==0) throw new RuntimeException("Neuspesno");
/////////////////////////////////////////////////////////////////////////////////////////
            
            
            connection.commit();
        } catch (Exception ex){
            ex.printStackTrace();
            connection.rollback();
        }
    }

    public List<Nastavnik> getAllNastavnik() {
        
        try {
            String query = "SELECT * FROM Nastavnik";
            List<Nastavnik> vrati = new ArrayList<>();
            
            Konekcija konekcija = new Konekcija();
            konekcija.connect();
            
            Connection connection = konekcija.getConnection();
            
            
            
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            List<Zvanje> zvanja = getAllZvanja();
            
            while (rs.next()){
                int id = rs.getInt(1);
                String ime = rs.getString(2);
                String prezime = rs.getString(3);
                int idZvanje = rs.getInt(4);
                
                Zvanje zvanje = new Zvanje();
                
                for (Zvanje z : zvanja){
                    if (z.getId() == idZvanje){
                        zvanje = z;
                        break;
                    }
                }
                
                Nastavnik nastavnik = new Nastavnik(ime, prezime, id, zvanje);
                       
                vrati.add(nastavnik);
            }
            
            System.out.println(vrati.size());
            return vrati
                    ;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Neuspesno");
        }
    }
    
}
