package OV.Domein;


import java.time.LocalDate;

public class Reiziger {
    private int reizigerId;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private LocalDate geboortedatum;

    public Reiziger(int reizigerId, String voorletters, String tussenvoegsel, String achternaam, LocalDate geboortedatum) {
        this.reizigerId = reizigerId;
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
    }

    public int getReizigerId() {
        return reizigerId;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    @Override
    public String toString() {
        return String.format("Reiziger {#%d: %s %s %s, %s}",
                reizigerId, voorletters,
                (tussenvoegsel == null ? "" : tussenvoegsel),
                achternaam, geboortedatum);
    }
}
