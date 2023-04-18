
package edunova.controller;

import edunova.model.Operater;
import edunova.util.EdunovaException;
import jakarta.persistence.NoResultException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;

public class ObradaOperater extends Obrada<Operater> {

    @Override
    public List<Operater> read() {
        return session.createQuery("from Operater",Operater.class).list();
    }
    
    
    public void unosAdminOperatera() {
        Operater o = new Operater();
        o.setIme("admin");
        o.setPrezime("admin");
        o.setKorisnickoIme("admin");
        o.setLozinka(BCrypt.hashpw("admin", 
                BCrypt.gensalt()).toCharArray());
        
       // setEntitet(o);
        entitet=o;
        try {
            create();
        } catch (EdunovaException ex) {
            System.out.println(ex.getPoruka());
        }
        
        
    }
    
    public Operater autoriziraj(String korisnickoIme, char[] lozinka){
        Operater o;
        try {
            o = session.createQuery(
                    "from Operater o where o.korisnickoIme=:korisnickoIme", 
                    Operater.class)
                    .setParameter("korisnickoIme",korisnickoIme)
                    .getSingleResult();
            
        } catch (NoResultException e) {
            return null;
        }
        
        if(BCrypt.checkpw(
                new String(lozinka), 
                new String(o.getLozinka())
                            )
                ){
            return o;
        }
        
        return null;
    }

    @Override
    protected void kontrolaUnos() throws EdunovaException {
    }

    @Override
    protected void kontrolaPromjena() throws EdunovaException {
    }

    @Override
    protected void kontrolaBrisanje() throws EdunovaException {
    }
    
    
}