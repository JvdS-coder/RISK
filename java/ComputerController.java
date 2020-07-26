package novi.spring.RISK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ComputerController {

    @Autowired
    private ComputerRepository computerRepository;

    @GetMapping(value = "/api/computer")
    public Computer getComputer() {
        Optional<Computer> _computer = computerRepository.findById(1);
        if(_cmputer.isPresent()) {
            return _computer.get();
        } else {
            return null;
        }
    }

    @GetMapping(value = "/api/computer/{id}")
    public Computer getComputerById(@PathVariable int id) {
        Optional<Computer> _computer = computerRepository.findById(id);
        if(_computer.isPresent()) {
            return _computer.get();
        } else {
            return null;
        }
    }
}
