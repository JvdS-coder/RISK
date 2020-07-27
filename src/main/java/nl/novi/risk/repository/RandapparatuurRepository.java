package nl.novi.risk.repository;

import nl.novi.risk.domain.Randapparatuur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RandapparatuurRepository extends JpaRepository<Randapparatuur, Integer> {

    Optional<Randapparatuur> findById(int id);

    Randapparatuur save(Randapparatuur randapparatuur);

    void delete(Randapparatuur randapparatuur);
}