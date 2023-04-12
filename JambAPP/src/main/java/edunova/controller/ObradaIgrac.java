
package edunova.controller;

import edunova.model.Igrac;
import edunova.util.EdunovaException;
import java.util.List;


//ObradaOsoba<T extends Osoba> extends Obrada<T>{

public class ObradaIgrac extends Obrada<Igrac>{

    @Override
    protected void kontrolaUnos() throws EdunovaException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaKorisnickoIme();
    }

    @Override
    protected void kontrolaPromjena() throws EdunovaException {
        kontrolaKorisnickoImeNull();
        kontrolaKorisnickoImeMinimalnaDuzina();
        kontrolaKorisnickoImeMaksimalnaDuzina();
    }

    @Override
    protected void kontrolaBrisanje() throws EdunovaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public List<Igrac> read() {
        return session.createQuery("from Igrac", Igrac.class).list();
    }
    
    
    private void kontrolaKorisnickoIme() throws EdunovaException  {
        kontrolaKorisnickoImeNull();
        kontrolaKorisnickoImeMinimalnaDuzina();
        kontrolaKorisnickoImeMaksimalnaDuzina();
        kontrolaKorisnickoImeDupliUBazi();
    }
    
    private void kontrolaKorisnickoImeDupliUBazi() throws EdunovaException  {
        List<Igrac> igraci=null;
        try {
            igraci = session.createQuery("from Igrac i "
                    + " where i.korisnickoIme=:korisnickoIme", 
                    Igrac.class)
                    .setParameter("korisnickoIme", entitet.getKorisnickoIme())
                    .list();
        } catch (Exception e) {
        }
        if(igraci!=null && !igraci.isEmpty()){
            throw new EdunovaException("Igrac sa istim korisnickim imenom postoji u bazi");
        }
    }
    
    private void kontrolaKorisnickoImeMinimalnaDuzina() throws EdunovaException  {
         if(entitet.getKorisnickoIme().trim().length()<3){
             throw new EdunovaException("Korisnicko ime mora imati minimalno 3 znaka");
         } 
    }
    
    private void kontrolaKorisnickoImeMaksimalnaDuzina() throws EdunovaException  {
         if(entitet.getKorisnickoIme().trim().length()>50){
             throw new EdunovaException("Korisnicko ime može imati maksimalno 50 znakova");
         } 
    }
    
     private void kontrolaKorisnickoImeNull() throws EdunovaException  {
        if(entitet.getKorisnickoIme()==null){
            throw new EdunovaException("Korisnicko ime mora biti postavljeno");
        }
    }

    private void kontrolaIme() throws EdunovaException {
        if(entitet.getIme()==null){
            throw new EdunovaException("Ime mora biti postavljeno");
        }
        if(entitet.getIme().trim().length()<3){
             throw new EdunovaException("Ime mora imati minimalno 3 znaka");
         }
        if(entitet.getIme().trim().length()>50){
             throw new EdunovaException("Ime može imati maksimalno 50 znakova");
         } 
    }
    
    private void kontrolaPrezime() throws EdunovaException {
        if(entitet.getPrezime()==null){
            throw new EdunovaException("Prezime mora biti postavljeno");
        }
        if(entitet.getPrezime().trim().length()<3){
             throw new EdunovaException("Prezime mora imati minimalno 3 znaka");
         }
        if(entitet.getPrezime().trim().length()>50){
             throw new EdunovaException("Prezime može imati maksimalno 50 znakova");
         } 
    }

    

    
}
