package nl.novi.risk.repository.secure;

import nl.novi.risk.domain.Gebruiker;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * De JpaRepositories die jullie al kennen. Hier wordt gebruik gemaakt van Query Creation. Op basis van de methode naam_gebruiker
 * weten Spring en JPA welke query op de database uitgevoerd moet worden.
 * Hier kan meer informatie over gevonden worden:
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 */
public interface GebruikerRepository extends JpaRepository<Gebruiker, Long> {

    Optional<Gebruiker> findByUsername(String naam_gebruiker);
    Boolean existsByUsername(String naam_gebruiker);
    Boolean existsByEmail(String email_gebruiker);
}