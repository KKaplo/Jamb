package edunova.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Igrac extends Entitet {

    private String ime;
    private String prezime;
    private String korisnickoIme;

    @OneToMany(mappedBy = "igrac",cascade = {CascadeType.ALL})
    private List<Igra> igre;
    
    public Igrac() {
        super();
        igre = new ArrayList<>();
    }

    public Igrac(Integer sifra, String ime, String prezime, String korisnickoIme,List<Igra> igre) {
        super(sifra);
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.igre=igre;
    }

    public List<Igra> getIgre() {
        return igre;
    }

    public void setIgre(List<Igra> igre) {
        this.igre = igre;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    @Override
    public String toString() {
        return korisnickoIme;

    }
}
