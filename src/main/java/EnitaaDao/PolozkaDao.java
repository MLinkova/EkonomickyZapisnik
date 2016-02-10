package EnitaaDao;


import EnitaaDao.Polozka;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Robert Link
 */
public interface PolozkaDao {
    public void pridaj(Polozka polozka);
    public void odstanit(Polozka polozka);
    public List<Polozka> dajVsetky();
    public List<Polozka> vypisPrijmyCelkovo();
    public List<Polozka> vypisPrijmyMesacne(int mesiac);
    public List<Polozka> vypisVydavkyCelkovo();
    public List<Polozka> vypisVydajvkyMesacne(int mesiac);
    public double sumaPrijmyCelkovo();
    public double sumaPrijmyMesacne(int mesiac);
    public double sumaVydajkyMesacne(int mesiac);
    public double sumaVydavkyCelkovo();
    public List<Polozka> hladat(String s);
    public void upravit(Polozka polozka);
   
    

}
