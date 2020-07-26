import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SoftwareController {

    @Autowired
    private SoftwareRepository softwareRepository;

    @GetMapping(value = "/api/software")
    public Software getSoftware() {
        Optional<Software> _software = softwareRepository.findById(1);
        if(_software.isPresent()) {
            return _software.get();
        } else {
            return null;
        }
    }

    @GetMapping(value = "/api/software/{id}")
    public Software getSoftwareById(@PathVariable int id) {
        Optional<Software> _software = softwareRepository.findById(id);
        if(_software.isPresent()) {
            return _software.get();
        } else {
            return null;
        }
    }
}
