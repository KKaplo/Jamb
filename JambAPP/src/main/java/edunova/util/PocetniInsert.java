package edunova.util;

import com.github.javafaker.Faker;
import edunova.model.Igra;
import edunova.model.Igrac;
import edunova.model.Polje;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.hibernate.Session;

public class PocetniInsert {

    private static final int BROJ_IGRACA = 100;

    private Faker faker;
    private List<Igrac> igraci;
    private List<Igra> igre;
    private Session session;

    public PocetniInsert() {
        faker = new Faker();
        igraci = new ArrayList<>();
        igre = new ArrayList<>();
        session = HibernateUtil.getSession();
        session.beginTransaction();
        kreirajIgrace();
        kreirajIgre();

        session.getTransaction().commit();
    }

    private void kreirajIgre() {
        Igra igra;
        for (int i = 0; i < BROJ_IGRACA; i++) {
            for (int j = 0; j < slucajniBroj(0, 7); j++) {
                igra = new Igra();
                igra.setIgrac(igraci.get(i));
                igra.setPolja(kreirajPolja (igra));
                session.persist(igra);
                igre.add(igra);
            }
        }
    }

    private void kreirajIgrace() {
        Igrac igr;
        for (int i = 0; i < BROJ_IGRACA; i++) {
            igr = new Igrac();
            igr.setIme(faker.name().firstName());
            igr.setPrezime(faker.name().lastName());
            igr.setKorisnickoIme(igr.getPrezime() + faker.number().randomNumber());
            session.persist(igr);
            igraci.add(igr);
        }
    }

    private Polje kreirajPolje(String naziv, int vrijednost, Igra igra) {
        Polje polje = new Polje();
        polje.setNaziv(naziv);
        polje.setVrijednost(vrijednost);
        polje.setIgra(igra);
        return polje;
    }

    private List<Polje> kreirajPolja(Igra igra) {
        List<Polje> polja = new ArrayList<>();
        Polje polje;
        ArrayList<Integer> list = new ArrayList<>();

        polje = kreirajPolje("jedanDolje", slucajniBrojPolje(1), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("jedanGore", slucajniBrojPolje(1), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("jedanSloboda", slucajniBrojPolje(1), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("jedanNajava", slucajniBrojPolje(1), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("jedanRucno", slucajniBrojPolje(1), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("dvaDolje", slucajniBrojPolje(2), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("dvaGore", slucajniBrojPolje(2), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("dvaSloboda", slucajniBrojPolje(2), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("dvaNajava", slucajniBrojPolje(2), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("dvaRucno", slucajniBrojPolje(2), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("triDolje", slucajniBrojPolje(3), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("triGore", slucajniBrojPolje(3), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("triSloboda", slucajniBrojPolje(3), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("triNajava", slucajniBrojPolje(3), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("triRucno", slucajniBrojPolje(3), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("cetiriDolje", slucajniBrojPolje(4), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("cetiriGore", slucajniBrojPolje(4), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("cetiriSloboda", slucajniBrojPolje(4), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("cetiriNajava", slucajniBrojPolje(4), igra);
        polja.add(polje);

        polje = kreirajPolje("cetiriRucno", slucajniBrojPolje(4), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("petDolje", slucajniBrojPolje(5), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("petGore", slucajniBrojPolje(5), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("petSloboda", slucajniBrojPolje(5), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("petNajava", slucajniBrojPolje(5), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("petRucno", slucajniBrojPolje(5), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("sestDolje", slucajniBrojPolje(6), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("sestGore", slucajniBrojPolje(6), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("sestSloboda", slucajniBrojPolje(6), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("sestNajava", slucajniBrojPolje(6), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("sestRucno", slucajniBrojPolje(6), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("maksimumDolje", slucajniBrojPolje(24, 30), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("maksimumGore", slucajniBrojPolje(24, 30), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("maksimumSloboda", slucajniBrojPolje(24, 30), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("maksimumNajava", slucajniBrojPolje(24, 30), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("maksimumRucno", slucajniBrojPolje(24, 30), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("minimumDolje", slucajniBrojPolje(5, 11), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("minimumGore", slucajniBrojPolje(5, 11), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("minimumSloboda", slucajniBrojPolje(5, 11), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("minimumNajava", slucajniBrojPolje(5, 11), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("minimumRucno", slucajniBrojPolje(5, 11), igra);
        session.persist(polje);
        polja.add(polje);

        Collections.addAll(list, 0, 14, 16, 18, 20, 22,
                24, 26, 28, 30, 32);

        polje = kreirajPolje("dvaParaDolje", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("dvaParaGore", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("dvaParaSloboda", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("dvaParaNajava", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("dvaParaRucno", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        list.clear();
        Collections.addAll(list, 0, 35, 35, 35, 45, 45, 45, 45, 45);

        polje = kreirajPolje("skalaDolje", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("skalaGore", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("skalaSloboda", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("skalaNajava", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("skalaRucno", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        list.clear();
        Collections.addAll(list, 0,
                37, 39, 41, 43, 45,
                38, 41, 44, 47, 50,
                40, 42, 44, 46,
                45, 48, 51, 54,
                47, 49, 51,
                48, 51, 54,
                52, 54,
                53, 56,
                57, 58);

        polje = kreirajPolje("fullDolje", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("fullGore", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("fullSloboda", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("fullNajava", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("fullRucno", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        list.clear();
        Collections.addAll(list, 0, 44, 48, 48,
                52, 52, 56, 56, 56, 60, 60,
                60, 64, 64);

        polje = kreirajPolje("pokerDolje", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("pokerGore", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("pokerSloboda", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("pokerNajava", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("pokerRucno", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        list.clear();
        Collections.addAll(list, 0, 0, 0,
                55, 60, 65, 70, 75, 80
        );

        polje = kreirajPolje("jambDolje", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("jambGore", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("jambSloboda", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("jambNajava", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        polje = kreirajPolje("jambRucno", slucajniBrojPoljeOdaberiRandom(list), igra);
        session.persist(polje);
        polja.add(polje);

        return polja;

    }

    private int slucajniBrojPolje(int mnozitelj) {
        int x = ThreadLocalRandom.current().nextInt(0, 6);
        x += ThreadLocalRandom.current().nextInt(0, 6);
        x += ThreadLocalRandom.current().nextInt(0, 6);
        x += ThreadLocalRandom.current().nextInt(0, 6);
        return mnozitelj * (int) (Math.ceil((double) x / 4));

    }

    private int slucajniBrojPolje(int min, int max) {
        int x = ThreadLocalRandom.current().nextInt(min, max + 1);
        x += ThreadLocalRandom.current().nextInt(min, max + 1);
        x += ThreadLocalRandom.current().nextInt(min, max + 1);
        x += ThreadLocalRandom.current().nextInt(min, max + 1);
        return (int) (Math.ceil((double) x / 4));

    }

    private int slucajniBrojPoljeOdaberiRandom(List<Integer> list) {
        int x = ThreadLocalRandom.current().nextInt(0, list.size());
        return list.get(x);
    }

    private int slucajniBroj(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
