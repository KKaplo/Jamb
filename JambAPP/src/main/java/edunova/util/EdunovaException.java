
package edunova.util;

public class EdunovaException extends Exception{
    
    private String poruka;

    public EdunovaException(String poruka) {
        super();
        this.poruka = poruka;
    }

    public String getPoruka() {
        return poruka;
    }
    
    
    
    
    
    
}
