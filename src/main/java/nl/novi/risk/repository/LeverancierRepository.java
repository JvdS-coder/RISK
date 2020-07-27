package nl.novi.risk.repository;

import nl.novi.risk.domain.Leverancier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LeverancierRepository extends JpaRepository<Leverancier, Integer> {

    Optional<Leverancier> findById(int id);

    Leverancier save(Leverancier leverancier);

    void delete(Leverancier leverancier);
}
