package nl.novi.risk.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.novi.risk.domain.Gebruiker;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GebruikerDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;
    private Long nr_gebruiker;
    private String naam_gebruiker;
    private String email_gebruiker;
    private String afdeling_gebruiker;
    private LocalDate laatste_inlogdatum;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    private GebruikerDetailsImpl() {}

    private GebruikerDetailsImpl(Long nr_gebruiker, String naam_gebruiker, String email_gebruiker,
                                String afdeling_gebruiker, String password, LocalDate laatste_inlogdatum,
                                Collection<? extends GrantedAuthority> authorities) {
        this.nr_gebruiker = nr_gebruiker;
        this.naam_gebruiker = naam_gebruiker;
        this.email_gebruiker = email_gebruiker;
        this.afdeling_gebruiker = afdeling_gebruiker;
        this.laatste_inlogdatum = laatste_inlogdatum;
        this.authorities = authorities;
        this.password = password;
    }

    public static GebruikerDetailsImpl build(Gebruiker gebruiker) {
        List<GrantedAuthority> authorities = gebruiker.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getNaam().name()))
                .collect(Collectors.toList());

        return new GebruikerDetailsImpl(
                gebruiker.getNr_gebruiker(),
                gebruiker.getNaam_gebruiker(),
                gebruiker.getEmail_gebruiker(),
                gebruiker.getAfdeling_gebruiker(),
                gebruiker.getPassword(),
                gebruiker.getLaatste_inlogdatum(),
                authorities
        );
    }


    public Long getNr_gebruiker() {
        return nr_gebruiker;
    }

    public String getNaam_gebruiker() {
        return naam_gebruiker;
    }

    public String getEmail_gebruiker() {
        return email_gebruiker;
    }

    public String getAfdeling_gebruiker() {
        return afdeling_gebruiker;
    }

    public LocalDate getLaatste_inlogdatum() {
        return laatste_inlogdatum;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GebruikerDetailsImpl that = (GebruikerDetailsImpl) o;
        return nr_gebruiker.equals(that.nr_gebruiker) &&
                naam_gebruiker.equals(that.naam_gebruiker) &&
                email_gebruiker.equals(that.email_gebruiker) &&
                Objects.equals(afdeling_gebruiker, that.afdeling_gebruiker) &&
                Objects.equals(laatste_inlogdatum, that.laatste_inlogdatum) &&
                password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nr_gebruiker, naam_gebruiker, email_gebruiker, afdeling_gebruiker, laatste_inlogdatum, password, authorities);
    }
}
