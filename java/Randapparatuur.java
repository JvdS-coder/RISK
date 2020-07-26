import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Randapparatuur {
    @Id
    @GeneratedValue

    //attributen:
    private int ranr;
    private String soort;
    private String merk;
    private String type;
    private String afdeling;
    private String locatie;
    private String beeldscherm;
    private String formaatbeeldscherm;
    private String aansluitingenbeeldscherm;
    private String videokaart;
    private String videogeheugen;
    private Date aankoopdatum;
    private Date afloopdatum;
    private String levnr;
    private String onderhoudscontract;
    private String merkprinter;
    private String typeprinter;

    public Randaparatuur() {

    }

    // constructor
    public Randapparatuur(String merk) {
        this.ranr = ranr;
        this.merk = merk;
        this.type = type;
        this.afdeling = afdeling;
        this.locatie = locatie;
        this.beeldscherm = beeldscherm;
        this.formaatbeeldscherm = formaatbeeldscherm;
        this.aansluitingenbeeldscherm = aansluitingenbeeldscherm;
        this.videokaart = videokaart;
        this.videogeheugen = videogeheugen;
        this.aankoopdatum = aankoopdatum;
        this.afloopdatum = afloopdatum;
        this.levnr = levnr;
        this.onderhoudscontract = onderhoudscontract;
        this.merkprinter = merkprinter;
        this.typeprinter = typeprinter;
    }





























    //==============================
   // get methoden
    public String getMerk() { return merk; }
    public String getType() { return type; }
    public String getAfdeling() { return afdeling; }
    public String getLocatie() { return locatie; }
    public String getBeeldscherm() { return beeldscherm; }
    public String getFormaatbeeldscherm() { return formaatbeeldscherm; }
    public String getAansluitingenbeeldscherm() { return aansluitingenbeeldscherm; }
    public String getVideokaart() { return videokaart; }
    public String getVideogeheugen() { return videogeheugen; }
    public String getAankoopdatum() { return aankoopdatum; }
    public String getAfloopdatum() { return afloopdatum; }
    public String getLevnr() { return levnr; }
    public String getOnderhoudscontract() { return onderhoudscontract; }
    public String getMerkprinter() { return merkprinter; }
    public String getTypeprinter() { return typeprinter; }

    // set methoden
    public void setRanr(int ranr) {
        this.ranr = ranr;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    public void setBeeldscherm(String beeldscherm) {
        this.beeldscherm = beeldscherm;
    }

    public void setFormaatbeeldscherm(String formaatbeeldscherm) {
        this.formaatbeeldscherm = formaatbeeldscherm;
    }

    public void setAansluitingenbeeldscherm(String aansluitingenbeeldscherm) {
        this.aansluitingenbeeldscherm = aansluitingenbeeldscherm;
    }

    public void setVideokaart(String videokaart) {
        this.videokaart = videokaart;
    }

    public void setVideogeheugen(String videogeheugen) {
        this.videogeheugen = videogeheugen;
    }

    public void setAankoopdatum(Date aankoopdatum) {
        this.aankoopdatum = aankoopdatum;
    }

    public void setAfloopdatum(Date afloopdatum) {
        this.afloopdatum = afloopdatum;
    }

    public void setLevnr(String levnr) {
        this.levnr = levnr;
    }

    public void setOnderhoudscontract(String onderhoudscontract) {
        this.onderhoudscontract = onderhoudscontract;
    }

    public void setMerkprinter(String merkprinter) {
        this.merkprinter = merkprinter;
    }

    public void setTypeprinter(String typeprinter) {
        this.typeprinter = typeprinter;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }
}

