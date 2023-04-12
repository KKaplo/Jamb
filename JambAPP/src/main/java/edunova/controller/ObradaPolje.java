
package edunova.controller;

import edunova.model.Polje;
import edunova.util.EdunovaException;
import java.util.List;


public class ObradaPolje extends Obrada<Polje> {

    @Override
    public List<Polje> read() {
        return session.createQuery("from Polje", 
                Polje.class).list();
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
