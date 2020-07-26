package nl.novi.risk.repository;

import nl.novi.risk.domain.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {

    Optional<Computer> findById(int computerId);

    Computer save(Computer computer);


    void deleteById(int computerId);

    void save();
}
