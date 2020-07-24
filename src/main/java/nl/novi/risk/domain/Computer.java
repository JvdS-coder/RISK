package nl.novi.risk.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Computer {
    @Id
    @GeneratedValue

    // attributen
    private int pcnr;
    private String merk;
    private String type;
    private String afdeling;
    private String locatie;
    private String telnrcontactpersoon;
    private int leverancier;
    private String onderhoudscontract;
    private Date aankoopdatum;
    private Date afloopdatum;
    private String interngeheugen;
    private String processor;
    private String hd_1_capaciteit;
    private String hd_1_type;
    private String hd_2_capaciteit;
    private String hd_2_type;
    private String ext_hd_capaciteit;
    private String ext_hd_type;
    private String type_usb_aansluitingen;

    public Computer() {

    }

    public int getPcnr() {
        return pcnr;
    }

    // constructor
    public Computer(int pcnr, String merk, String type, String afdeling, String locatie, String telnrcontactpersoon, int leverancier, String onderhoudscontract, Date aankoopdatum, Date afloopdatum, String interngeheugen, String processor, String hd_1_capaciteit, String hd_1_type, String hd_2_capaciteit, String hd_2_type, String ext_hd_capaciteit, String ext_hd_type, String type_usb_aansluitingen) {
        this.pcnr = pcnr;
        this.merk = merk;
        this.type = type;
        this.afdeling = afdeling;
        this.locatie = locatie;
        this.leverancier = leverancier;
        this.telnrcontactpersoon = telnrcontactpersoon;
        this.onderhoudscontract = onderhoudscontract;
        this.aankoopdatum = aankoopdatum;
        this.afloopdatum = afloopdatum;
        this.interngeheugen = interngeheugen;
        this.processor = processor;
        this.hd_1_capaciteit = hd_1_capaciteit;
        this.hd_1_type = hd_1_type;
        this.hd_2_capaciteit = hd_2_capaciteit;
        this.hd_2_type = hd_2_type;
        this.ext_hd_capaciteit = ext_hd_capaciteit;
        this.ext_hd_type = ext_hd_type;
        this.type_usb_aansluitingen = type_usb_aansluitingen;
    }

    // get methoden
    public String getMerk() { return merk; }
    public String getType() { return type; }
    public String getAfdeling() { return afdeling; }
    public String getLocatie() { return locatie; }
    public int getLeverancier() { return leverancier; }
    public String getTelnrcontactpersoon() { return telnrcontactpersoon; }
    public String getOnderhoudscontract() { return onderhoudscontract; }
    public Date getAankoopdatum() { return aankoopdatum; }
    public Date getAfloopdatum() { return afloopdatum; }
    public String getInterngeheugen() { return interngeheugen; }
    public String getProcessor() { return processor; }
    public String getHd_1_capaciteit() { return hd_1_capaciteit; }
    public String getHd_1_type() { return hd_1_type; }
    public String getHd_2_capaciteit() { return hd_2_capaciteit; }
    public String getHd_2_type() { return hd_2_type; }
    public String getExt_hd_capaciteit() { return ext_hd_capaciteit; }
    public String getExt_hd_type() { return ext_hd_type; }
    public String getType_usb_aansluitingen() { return type_usb_aansluitingen; }

    // set methoden
    public void setPcnr(int pcnr) {
        this.pcnr = pcnr;
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
    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }
    public void setTelnrcontactpersoon(String telnrcontactpersoon) {
        this.telnrcontactpersoon = telnrcontactpersoon;
    }
    public void setLeverancier(int leverancier) {
        this.leverancier = leverancier;
    }
    public void setOnderhoudscontract(String onderhoudscontract) {
        this.onderhoudscontract = onderhoudscontract;
    }
    public void setAankoopdatum(Date aankoopdatum) {
        this.aankoopdatum = aankoopdatum;
    }
    public void setAfloopdatum(Date afloopdatum) {
        this.afloopdatum = afloopdatum;
    }
    public void setInterngeheugen(String interngeheugen) {
        this.interngeheugen = interngeheugen;
    }
    public void setProcessor(String processor) {
        this.processor = processor;
    }
    public void setHd_1_capaciteit(String hd_1_capaciteit) {
        this.hd_1_capaciteit = hd_1_capaciteit;
    }
    public void setHd_1_type(String hd_1_type) {
        this.hd_1_type = hd_1_type;
    }
    public void setHd_2_capaciteit(String hd_2_capaciteit) {
        this.hd_2_capaciteit = hd_2_capaciteit;
    }
    public void setHd_2_type(String hd_2_type) {
        this.hd_2_type = hd_2_type;
    }
    public void setExt_hd_capaciteit(String ext_hd_capaciteit) {
        this.ext_hd_capaciteit = ext_hd_capaciteit;
    }
    public void setExt_hd_type(String ext_hd_type) {
        this.ext_hd_type = ext_hd_type;
    }
    public void setType_usb_aansluitingen(String type_usb_aansluitingen) { this.type_usb_aansluitingen = type_usb_aansluitingen; }
}
