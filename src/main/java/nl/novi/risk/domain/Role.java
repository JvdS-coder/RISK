package nl.novi.risk.domain;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Role")
public class Role {

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

    @Enumerated(EnumType.STRING)
    private ERole naam;

    public Role() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ERole getNaam() {
        return naam;
    }

    public void setNaam(ERole naam) {
        this.naam = naam;
    }

    public Role(ERole naam) { this.naam = naam; }

    @ManyToMany(mappedBy = "roles")
    private Collection<Gebruiker> gebruiker;

    public Collection<Gebruiker> getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Collection<Gebruiker> gebruiker) {
        this.gebruiker = gebruiker;
    }
}
