package nl.novi.risk.repository;

import nl.novi.risk.domain.Storingen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoringRepository extends JpaRepository<Storingen, Integer> {

}