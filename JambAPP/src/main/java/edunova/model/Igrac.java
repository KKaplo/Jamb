package edunova.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Igrac extends Entitet {

    private String ime;
    private String prezime;
    private String korisnickoIme;
    @Column(columnDefinition = "char(61)")
    private char[] lozinka;

    

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
    
    public char[] getLozinka() {
        return lozinka;
    }

    public void setLozinka(char[] lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public String toString() {
        return korisnickoIme;

    }
}
