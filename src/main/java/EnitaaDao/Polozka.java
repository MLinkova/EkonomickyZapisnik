package EnitaaDao;


import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Robert Link
 */
public class Polozka {
    
    private int Id;
    private String nazov;
    private Date datum;
    private double suma;
    private String kategoria;
     private SimpleDateFormat dateFormat = new SimpleDateFormat("d.M.yyyy");

    @Override
    public String toString() {
        return  nazov +", " + dateFormat.format(datum)+", " + suma +", "+ kategoria ;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }
    
    
    
    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }
    
    
    
}
