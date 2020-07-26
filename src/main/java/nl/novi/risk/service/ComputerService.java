package nl.novi.risk.service;

import nl.novi.risk.domain.Computer;
import nl.novi.risk.repository.ComputerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ComputerService  {

    private ComputerRepository computerRepository;

    public List<Computer> getComputers() {
        List<Computer> listComputers = computerRepository.findAll();
        return listComputers;
    }

    public Computer getComputerById(int computerId) {
        Optional<Computer> computer = computerRepository.findById(computerId);
        if(computer.isPresent()) {
            return computer.get();
        } else {
            return new ComputerNotFoundException("Computer bestaat niet met dit id: " + computerId);
        }
    }

    public Computer createComputer(Computer computer) {
        return computerRepository.save(computer);
    }

    public String updateComputer(int computerId) {
        Optional<Computer> computer = computerRepository.findById(computerId);
        if(computer.isPresent()) {
            computerRepository.save();
            return "Gegevens van Computer met id " + computerId + " zijn aangepast.";
        } else {
            return new String("Computer bestaat niet met dit id: " + computerId);
        }
    }

    public String deleteComputer(int computerId) {
        Optional<Computer> computer = computerRepository.findById(computerId);

        if(computer.isPresent()) {
            computerRepository.deleteById(computerId);
            return "Computer met id " + computerId + " is verwijderd.";
        }
        return new String("Computer met id " + computerId + " bestaat niet of is reeds verwijderd.");
    }

    public Computer findById(int computerId) {
    }
}