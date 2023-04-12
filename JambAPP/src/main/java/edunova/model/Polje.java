package edunova.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Polje extends Entitet {

    private String naziv;
    private int vrijednost;
    
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "igra")
    private Igra igra;

    public Polje() {
        super();
    }

    public Igra getIgra() {
        return igra;
    }

    public void setIgra(Igra igra) {
        this.igra = igra;
    }

    public Polje(int sifra, String naziv, int vrijednost,Igra igra) {
        super(sifra);
        this.naziv = naziv;
        this.vrijednost = vrijednost;
        this.igra=igra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getVrijednost() {
        return vrijednost;
    }

    public void setVrijednost(int vrijednost) {
        this.vrijednost = vrijednost;
    }

}
