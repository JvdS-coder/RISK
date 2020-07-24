package nl.novi.risk.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Leverancier {
    @Id
    @GeneratedValue

    // attributen
    private int levnr;
    private String naam;
    private String adres;
    private String postcode;
    private String vestigingsplaats;
    private String provincie_state;
    private String land_country;
    private String telefoonleverancier;
    private String emailleverancier;

    public Leverancier() {

    }

    public int getLevnr() {
        return levnr;
    }

    // constructor
    public Leverancier(int levnr, String naam, String adres, String postcode, String vestigingsplaats, String provincie_state, String land_country, String telefoonleverancier, String emailleverancier) {
        this.levnr = levnr;
        this.naam = naam;
        this.adres = adres;
        this.postcode = postcode;
        this.vestigingsplaats = vestigingsplaats;
        this.provincie_state = provincie_state;
        this.land_country = land_country;
        this.telefoonleverancier = telefoonleverancier;
        this.emailleverancier = emailleverancier;
    }

    // get methoden
    public String getNaam() { return naam; }
    public String getAdres() { return adres; }
    public String getPostcode() { return postcode; }
    public String getVestigingsplaats() { return vestigingsplaats; }
    public String getProvincie_state() { return provincie_state; }
    public String getLand_country() { return land_country; }
    public String getTelefoonleverancier() { return telefoonleverancier; }
    public String getEmailleverancier() { return emailleverancier; }

    // set methoden
    public void setLevnr(int levnr) { this.levnr = levnr; }
    public void setNaam(String naam) { this.naam = naam; }
    public void setAdres(String adres) { this.adres = adres; }
    public void setPostcode(String postcode) { this.postcode = postcode; }
    public void setVestigingsplaats(String vestigingsplaats) { this.vestigingsplaats = vestigingsplaats; }
    public void setProvincie_state(String provincie_state) { this.provincie_state = provincie_state; }
    public void setLand_country(String land_country) { this.land_country = land_country; }
    public void setTelefoonleverancier(String telefoonleverancier) { this.telefoonleverancier = telefoonleverancier; }
    public void setEmailleverancier(String emailleverancier) { this.emailleverancier = emailleverancier; }
}