package nl.novi.risk.service;

import nl.novi.risk.domain.Computer;
import nl.novi.risk.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService  {

    @Autowired
    private ComputerRepository computerRepository;

    public List<Computer> getComputers() {
        List<Computer> listComputers = computerRepository.findAll();
        return listComputers;
    }

    public Computer getComputerById(int id) {
        Optional<Computer> computer = computerRepository.findById(id);
        if(computer.isPresent()) {
            return computer.get();
        } else {
            //TODO Wat als er geen computer gevonden kan worden?
            return null;
        }
    }

    public Computer createComputer(Computer computer) {
        return computerRepository.save(computer);
    }

    public String deleteComputer(int computerId) {
        Optional<Computer> computer = computerRepository.findById(computerId);

        if(computer.isPresent()) {
            computerRepository.deleteById(computerId);
            return "Computer met id " + computerId + " is verwijderd.";
        }
        //TODO Exceptie
        return "Computer met id bestaat niet.";
    }






}