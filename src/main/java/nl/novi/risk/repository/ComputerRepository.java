package nl.novi.risk.repository;

import nl.novi.risk.domain.Computer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ComputerRepository extends JpaRepository<Computer, Integer> {

}
