package nl.novi.risk.domain;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "gebruiker")
public class Gebruiker {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(columnDefinition = "serial")
    private long nr_gebruiker;
    private String naam_gebruiker;
    private String email_gebruiker;
    private String afdeling_gebruiker;
    private LocalDate laatste_inlogdatum;

    private String password;

    @ManyToMany
    @JoinTable (name = "gebruiker_role",
    joinColumns = @JoinColumn(name = "nr_gebruiker"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Gebruiker() {

    }

    public Gebruiker(String naam_gebruiker, String email_gebruiker, String afdeling_gebruiker,
                     LocalDate laatste_inlogdatum, String password) {
        this.naam_gebruiker = naam_gebruiker;
        this.email_gebruiker = email_gebruiker;
        this.afdeling_gebruiker = afdeling_gebruiker;
        this.laatste_inlogdatum = laatste_inlogdatum;
        this.password = password;
    }

    public long getNr_gebruiker() {
        return nr_gebruiker;
    }

    public void setNr_gebruiker(long nr_gebruiker) {
        this.nr_gebruiker = nr_gebruiker;
    }

    public String getNaam_gebruiker() {
        return naam_gebruiker;
    }

    public void setNaam_gebruiker(String naam_gebruiker) {
        this.naam_gebruiker = naam_gebruiker;
    }

    public String getEmail_gebruiker() {
        return email_gebruiker;
    }

    public void setEmail_gebruiker(String email_gebruiker) {
        this.email_gebruiker = email_gebruiker;
    }

    public String getAfdeling_gebruiker() {
        return afdeling_gebruiker;
    }

    public void setAfdeling_gebruiker(String afdeling_gebruiker) {
        this.afdeling_gebruiker = afdeling_gebruiker;
    }

    public LocalDate getLaatste_inlogdatum() {
        return laatste_inlogdatum;
    }

    public void setLaatste_inlogdatum(LocalDate laatste_inlogdatum) {
        this.laatste_inlogdatum = laatste_inlogdatum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
