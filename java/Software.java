import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Software {
    @Id
    @GeneratedValue

    //attributen:
    private int sanr;
    private String merk;
    private String versie;
    private String leverancier;
    private String klantnummer;
    private String helpdesksupport;
    private String licentienummer;
    private int licentieaantal;
    private Date afloopdatum;
    private String mincriteriaos;
    private String mincriteriaram;
    private String mincriteriavideo;
    private String mincriteriaopslag;

    public Software() {

    }

    // constructor
    public Software(String merk) {
        this.merk = merk;
        this.versie = versie;
        this.leverancier = leverancier;
        this.klantnummer = klantnummer;
        this.helpdesksupport = helpdesksupport;
        this.licentienummer = licentienummer;
        this.licentieaantal = licentieaantal;
        this.afloopdatum = afloopdatum;
        this.mincriteriaos = mincriteriaos;
        this.mincriteriaram = mincriteriaram;
        this.mincriteriavideo = mincriteriavideo;
        this.mincriteriaopslag = mincriteriaopslag;
    }

    // get methoden
    public int getSanr() {
        return sanr;
    }

    public void setSanr(int sanr) {
        this.sanr = sanr;
    }

    public String getVersie() {
        return versie;
    }

    public void setVersie(String versie) {
        this.versie = versie;
    }

    public String getKlantnummer() {
        return klantnummer;
    }

    public void setKlantnummer(String klantnummer) {
        this.klantnummer = klantnummer;
    }

    public String getHelpdesksupport() {
        return helpdesksupport;
    }

    // set methoden
    public void setHelpdesksupport(String helpdesksupport) {
        this.helpdesksupport = helpdesksupport;
    }

    public String getLicentienummer() {
        return licentienummer;
    }

    public void setLicentienummer(String licentienummer) {
        this.licentienummer = licentienummer;
    }

    public int getLicentieaantal() {
        return licentieaantal;
    }

    public void setLicentieaantal(int licentieaantal) {
        this.licentieaantal = licentieaantal;
    }

    public String getMincriteriaos() {
        return mincriteriaos;
    }

    public void setMincriteriaos(String mincriteriaos) {
        this.mincriteriaos = mincriteriaos;
    }

    public String getMincriteriaram() {
        return mincriteriaram;
    }

    public void setMincriteriaram(String mincriteriaram) {
        this.mincriteriaram = mincriteriaram;
    }

    public String getMincriteriavideo() {
        return mincriteriavideo;
    }

    public void setMincriteriavideo(String mincriteriavideo) {
        this.mincriteriavideo = mincriteriavideo;
    }

    public String getMincriteriaopslag() {
        return mincriteriaopslag;
    }

    public void setMincriteriaopslag(String mincriteriaopslag) {
        this.mincriteriaopslag = mincriteriaopslag;
    }
}

