package nl.novi.risk.repository;

import nl.novi.risk.domain.Software;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SoftwareRepository extends JpaRepository<Software, Integer> {

    Optional<Software> findById(int id);

    Software save(Software software);

    void delete(Software software);
}