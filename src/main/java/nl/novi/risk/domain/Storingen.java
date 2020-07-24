package nl.novi.risk.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Storingen {
    @Id
    @GeneratedValue

    // attributen
    private int stnr;
    private int pcrndswnr;
    private String prioriteit;
    private Date datumstoring;
    private Date datumstoplossing;
    private String kostenstoring;
    private String omschrijvingstoring;
    private String omschrijvingoplossing;

    public Storingen() {

    }

    // constructor
    public Storingen(int stnr, int pcrndswnr, String prioriteit, Date datumstoring, Date datumstoplossing, String kostenstoring, String omschrijvingstoring, String omschrijvingoplossing) {
        this.stnr = stnr;
        this.pcrndswnr = pcrndswnr;
        this.prioriteit = prioriteit;
        this.datumstoring = datumstoring;
        this.datumstoplossing = datumstoplossing;
        this.kostenstoring = kostenstoring;
        this.omschrijvingstoring = omschrijvingstoring;
        this.omschrijvingoplossing = omschrijvingoplossing;
    }

    // get methoden
    public int getStnr() { return stnr; }
    public int getPcrndswnr() { return pcrndswnr; }
    public String getPrioriteit() { return prioriteit; }
    public Date getDatumstoring() { return datumstoring; }
    public Date getDatumstoplossing() { return datumstoplossing; }
    public String getKostenstoring() { return kostenstoring; }
    public String getOmschrijvingstoring() { return omschrijvingstoring; }
    public String getOmschrijvingoplossing() { return omschrijvingoplossing; }

    // set methoden
    public void setStnr(int stnr) { this.stnr = stnr; }
    public void setPcrndswnr(int pcrndswnr) { this.pcrndswnr = pcrndswnr; }
    public void setPrioriteit(String prioriteit) { this.prioriteit = prioriteit; }
    public void setDatumstoring(Date datumstoring) { this.datumstoring = datumstoring; }
    public void setDatumstoplossing(Date datumstoplossing) { this.datumstoplossing = datumstoplossing; }
    public void setKostenstoring(String kostenstoring) { this.kostenstoring = kostenstoring; }
    public void setOmschrijvingstoring(String omschrijvingstoring) { this.omschrijvingstoring = omschrijvingstoring; }
    public void setOmschrijvingoplossing(String omschrijvingoplossing) { this.omschrijvingoplossing = omschrijvingoplossing; }
}