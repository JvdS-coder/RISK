package persistence;

import nl.novi.risk.domain.Computer;
import org.springframework.data.repository.CrudRepository;


public interface ComputerRepository extends CrudRepository<Computer, Integer> {

}
