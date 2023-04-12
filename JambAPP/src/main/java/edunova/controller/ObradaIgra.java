
package edunova.controller;

import edunova.model.Igra;
import edunova.util.EdunovaException;
import java.util.List;

/**
 *
 * @author Karlo
 */
public class ObradaIgra extends Obrada<Igra> {

    @Override
    public List<Igra> read() {
        return session.createQuery("from Igra", 
                Igra.class).list();
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
