package nl.novi.risk.repository;

import nl.novi.risk.domain.Storing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoringRepository extends JpaRepository<Storing, Integer> {

    Optional<Storing> findById(int id);

    Storing save(Storing storing);

    void delete(Storing storing);
}