package nl.novi.risk.domain;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Set;

@Entity
@Table(name = "Gebruiker")
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
    private long id;
    private String gebruikersnaam;
    private String email;
    private String password;
    private String afdeling;
    private String role;

    @ManyToMany
    @JoinTable (name = "role",
    joinColumns = @JoinColumn(name = gebruiker_id),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Gebruiker() {

    }

    public Gebruiker(String gebruikersnaam, String email, String password, String afdeling, String role, Set<Role> roles) {
        this.gebruikersnaam = gebruikersnaam;
        this.email = email;
        this.password = password;
        this.afdeling = afdeling;
        this.role = role;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGebruikersNaam() {
        return gebruikersnaam;
    }

    public void setNaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(String afdeling) {
        this.afdeling = afdeling;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> roles) {
        this.role = role;
    }
}
