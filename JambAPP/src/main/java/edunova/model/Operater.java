
package edunova.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


@Entity
public class Operater extends Igrac{
    
    @Column(columnDefinition = "char(61)")
    private char[] lozinka;

    public char[] getLozinka() {
        return lozinka;
    }

    public void setLozinka(char[] lozinka) {
        this.lozinka = lozinka;
    }

    
    
    
}