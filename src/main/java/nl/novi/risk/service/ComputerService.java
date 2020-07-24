package nl.novi.risk.service;

import nl.novi.risk.persistence.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerService<CrudRepository> extends CrudRepository<Computer, Integer> {

    @Autowired
    private ComputerRepository computerRepository;

    public List<Computer> getComputer() {
        List<Computer> listComputer = (List<Computer>) computerRepository.findAll();
        return listComputer;
    }


}