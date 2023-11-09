/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvijeticant.domen;

/**
 *
 * @author Novica
 */
public class Predmet {
    
    private int id;
    private String naziv;
    private int espb;

    public Predmet() {
    }

    public Predmet(int id, String naziv, int espb) {
        this.id = id;
        this.naziv = naziv;
        this.espb = espb;
    }

    public int getEspb() {
        new Predmet();
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    
}
