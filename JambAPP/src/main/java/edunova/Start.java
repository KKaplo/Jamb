/*
nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package edunova;

//import edunova.util.HibernateUtil;

import edunova.controller.ObradaIgrac;
import edunova.model.Igrac;
import edunova.util.EdunovaException;

//import edunova.util.PocetniInsert;



public class Start {

    public static void main(String[] args) {
       //new PocetniInsert();
       ObradaIgrac igr = new ObradaIgrac();
        
        Igrac igrac = new Igrac();
        igrac.setIme("Karlo");
        igrac.setPrezime("Kapl");
        igrac.setKorisnickoIme("KKaplo");
        igr.setEntitet(igrac);
        try {
            igr.create();
        } catch (EdunovaException e) {
            System.out.println(e.getPoruka());
        }
        
        
        for(Igrac i : igr.read()){
            System.out.println(i.getKorisnickoIme());
        }
    }
}
