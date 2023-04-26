
package edunova.controller;

import edunova.model.Igra;
import edunova.model.Igrac;
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
    
    public List<Igra> read(Igrac i) {
        return session.createQuery("from Igra "
                + " where igrac=:i ",
                Igra.class)
                .setParameter("i", i)
                .list();
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
