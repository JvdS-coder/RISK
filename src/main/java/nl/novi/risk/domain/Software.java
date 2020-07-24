package nl.novi.risk.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Software {
    @Id
    @GeneratedValue

    // attributen
    private int swnr;
    private String naamapplicatie;
    private String versieapplicatie;
    private int levnummer;
    private String klantnummer;
    private String helpdesksupport;
    private String licentienummer;
    private int licentieaantal;
    private String afloopdatum;
    private String minvereistos;
    private String minramgeheugen;
    private String minopslagruimte;
    private String minvideogeheugen;

    public Software() {

    }

    public int getSwnr() {
        return swnr;
    }

    // constructor
    public Software(int swnr, String naamapplicatie, String versieapplicatie, int levnummer, String klantnummer, String helpdesksupport, String licentienummer, int licentieaantal, String afloopdatum, String minvereistos, String minramgehuegen, String minopslagruimte, String minvideogeheugen) {
        this.swnr = swnr;
        this.naamapplicatie = naamapplicatie;
        this.versieapplicatie = versieapplicatie;
        this.levnummer = levnummer;
        this.klantnummer = klantnummer;
        this.helpdesksupport = helpdesksupport;
        this.licentienummer = licentienummer;
        this.licentieaantal = licentieaantal;
        this.afloopdatum = afloopdatum;
        this.minvereistos = minvereistos;
        this.minramgeheugen = minramgeheugen;
        this.minopslagruimte = minopslagruimte;
        this.minvideogeheugen = minvideogeheugen;
    }

    // get methoden
    public String getNaamapplicatie() { return naamapplicatie; }
    public String getVersieapplicatie() { return versieapplicatie; }
    public int getLevnummer() { return levnummer; }
    public String getKlantnummer() { return klantnummer; }
    public String getHelpdesksupport() { return helpdesksupport; }
    public String getLicentienummer() { return licentienummer; }
    public int getLicentieaantal() { return licentieaantal; }
    public String getAfloopdatum() { return afloopdatum; }
    public String getMinvereistos() { return minvereistos; }
    public String getMinramgeheugen() { return minramgeheugen; }
    public String getMinopslagruimte() { return minopslagruimte; }
    public String getMinvideogeheugen() { return minvideogeheugen; }

    // set methoden
    public void setSwnr(int swnr) {
        this.swnr = swnr;
    }
    public void setNaamapplicatie(String naamapplicatie) {
        this.naamapplicatie = naamapplicatie;
    }
    public void setVersieapplicatie(String versieapplicatie) {
        this.versieapplicatie = versieapplicatie;
    }
    public void setLevnummer(int levnummer) {
        this.levnummer = levnummer;
    }
    public void setKlantnummer(String klantnummer) {
        this.klantnummer = klantnummer;
    }
    public void setHelpdesksupport(String helpdesksupport) {
        this.helpdesksupport = helpdesksupport;
    }
    public void setLicentienummer(String licentienummer) {
        this.licentienummer = licentienummer;
    }
    public void setLicentieaantal(int licentieaantal) {
        this.licentieaantal = licentieaantal;
    }
    public void setAfloopdatum(String afloopdatum) {
        this.afloopdatum = afloopdatum;
    }
    public void setMinvereistos(String minvereistos) {
        this.minvereistos = minvereistos;
    }
    public void setMinramgeheugen(String minramgeheugen) {
        this.minramgeheugen = minramgeheugen;
    }
    public void setMinopslagruimte(String minopslagruimte) {
        this.minopslagruimte = minopslagruimte;
    }
    public void setMinvideogeheugen(String minvideogeheugen) {
        this.minvideogeheugen = minvideogeheugen;
    }
}