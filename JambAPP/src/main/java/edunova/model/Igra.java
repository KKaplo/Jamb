package edunova.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Igra extends Entitet {

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Polje> polja;

    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "igrac")
    private Igrac igrac;

    public Igra() {
        super();
        polja = new ArrayList<>();
    }

    public Igra(int sifra, List<Polje> polja, Igrac igrac) {
        super(sifra);
        this.polja = polja;
        this.igrac = igrac;
    }

    public List<Polje> getPolja() {
        return polja;
    }

    public void setPolja(List<Polje> polja) {
        this.polja = polja;
    }

    public Igrac getIgrac() {
        return igrac;
    }

    public void setIgrac(Igrac igrac) {
        this.igrac = igrac;
    }

}
