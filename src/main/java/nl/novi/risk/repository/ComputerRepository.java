package nl.novi.risk.repository;

import nl.novi.risk.domain.Computer;
import nl.novi.risk.domain.Leverancier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {

    Optional<Computer> findById(int computerId);

    default Computer save(Computer computer) {
        return null;
    }

    void deleteById(int computerId);

    void save();
}
