/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.util;

import edunova.model.Igra;
import edunova.model.Polje;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Karlo
 */
public class KreiranjePrazneIgre {

    private Session session;
    private Igra igra;

    public Igra getIgra() {
        return igra;
    }
    
    public KreiranjePrazneIgre(){
        session = HibernateUtil.getSession();
        session.beginTransaction();
        
        igra = new Igra();
        igra.setIgrac(Aplikacija.IGRAC);
        igra.setPolja(kreirajPraznaPolja(igra));
        session.persist(igra);
        
        session.getTransaction().commit();
                
    }
    
    private Polje kreirajPolje(String naziv, int vrijednost, Igra igra) {
        Polje polje = new Polje();
        polje.setNaziv(naziv);
        polje.setVrijednost(vrijednost);
        polje.setIgra(igra);
        return polje;
    }

    private List<Polje> kreirajPraznaPolja(Igra igra) {

   
        List<Polje> polja = new ArrayList<>();
        Polje polje;

        polje = kreirajPolje("jedanDolje", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("jedanGore", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("jedanSloboda",-1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("jedanNajava", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("jedanRucno", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("dvaDolje", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("dvaGore", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("dvaSloboda", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("dvaNajava", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("dvaRucno", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("triDolje", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("triGore", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("triSloboda", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("triNajava", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("triRucno", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("cetiriDolje", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("cetiriGore", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("cetiriSloboda", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("cetiriNajava", -1, igra);
        polja.add(polje);

        polje = kreirajPolje("cetiriRucno", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("petDolje", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("petGore", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("petSloboda", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("petNajava", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("petRucno", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("sestDolje", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("sestGore", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("sestSloboda", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("sestNajava", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("sestRucno", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("maksimumDolje", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("maksimumGore", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("maksimumSloboda", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("maksimumNajava", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("maksimumRucno", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("minimumDolje", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("minimumGore", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("minimumSloboda", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("minimumNajava", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("minimumRucno", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("dvaParaDolje", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("dvaParaGore", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("dvaParaSloboda", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("dvaParaNajava", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("dvaParaRucno", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("skalaDolje", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("skalaGore", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("skalaSloboda", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("skalaNajava", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("skalaRucno", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("fullDolje", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("fullGore", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("fullSloboda", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("fullNajava", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("fullRucno", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("pokerDolje", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("pokerGore", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("pokerSloboda", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("pokerNajava", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("pokerRucno", -1, igra);
        session.persist(polje);
        polja.add(polje);   

        polje = kreirajPolje("jambDolje", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("jambGore", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("jambSloboda", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("jambNajava", -1, igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("jambRucno", -1, igra);
        session.persist(polje);
        polja.add(polje);

        return polja;

    }
}
