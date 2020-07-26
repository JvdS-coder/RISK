import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RandapparatuurController {

    @Autowired
    private RandapparatuurRepository randapparatuurRepository;

    @GetMapping(value = "/api/randapparatuur")
    public Randaparatuur getRandaparatuur() {
        Optional<Randaparatuur> _randaparatuur = RandaparatuurRepository.findById(1);
        if(_randaparatuur.isPresent()) {
            return _randaparatuur.get();
        } else {
            return null;
        }
    }

    @GetMapping(value = "/api/randaparatuur/{id}")
    public Randaparatuur getRandaparatuurById(@PathVariable int id) {
        Optional<Randaparatuur> _computer = randaparatuurRepository.findById(id);
        if(_randaparatuur.isPresent()) {
            return _randaparatuur.get();
        } else {
            return null;
        }
    }
}
