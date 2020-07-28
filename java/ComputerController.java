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
        if (_cmputer.isPresent()) {
            return _computer.get();
        } else {
            return null;
        }
    }

    @GetMapping(value = "/api/computer/{id}")
    public Computer getComputerById(@PathVariable int id) {
        Optional<Computer> _computer = computerRepository.findById(id);
        if (_computer.isPresent()) {
            return _computer.get();
        } else {
            return null;
        }
    }

    @PostMapping("/api/computer")
    public Computer createComputer(@Valid @RequestBody Computer computer) {
        return computerRepository.save(computer);
    }

    @DeleteMapping("/api/computer/{id}")
    public Map<String, Boolean> deleteComputer(@PathVariable(value = "id") Long ComputerId)
            throws ResourceNotFoundException {
        Computer computer = computerRepository.findById(Math.toIntExact(computerId))
                .orElseThrow(() -> new ResourceNotFoundException("Computer not found for this id :: " + computerId));
        computerRepository.delete(computer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/api/computer/{id}")
    public ResponseEntity<Computer> updateComputer(@PathVariable(value = "id") Long ComputerId,
                                                         @Valid @RequestBody Computer computerDetails) throws ResourceNotFoundException {
        Computer computer = computerRepository.findById(Math.toIntExact(computerId))
                .orElseThrow(() -> new ResourceNotFoundException("Computer not found for this id :: " + computerId));
        computer.setPcnr(computerDetails.getPcnr());
        computer.setMerk(computerDetails.getMerk());
        computer.setType(computerDetails.getType());
        computer.setAfdeling(computerDetails.getAfdeling());
        computer.setLocatie(computerDetails.getLocatie());
        computer.setTelnrcontactpersoon(computerDetails.getTelnrcontactpersoon());
        computer.setLeverancier(computerDetails.getLeverancier());
        computer.setOnderhoudscontract(computerDetails.getOnderhoudscontract());
        computer.setAankoopdatum(computerDetails.getAankoopdatum());
        computer.setAfloopdatum(computerDetails.getAfloopdatum());
        computer.setInterngeheugen(computerDetails.getInterngeheugen());
        computer.setProcessor(computerDetails.getProcessor());
        computer.setHd_1_capaciteit(computerDetails.getHd_1_capaciteit());
        computer.setHd_1_type(computerDetails.getHd_1_type());
        computer.setHd_2_capaciteit(computerDetails.getHd_2_capaciteit());
        computer.setHd_2_type(computerDetails.getHd_2_type());
        computer.setExt_hd_capaciteit(computerDetails.getExt_hd_capaciteit());
        computer.setExt_hd_type(computerDetails.getExt_hd_type());
        computer.setUsba(computerDetails.getUsba());
        computer.setUsbb(computerDetails.getUsbb());
        computer.setUsbc(computerDetails.getUsbc());
        computer.setUsbmini(computerDetails.getUsbmini());
        computer.setUsbmicro(computerDetails.getUsbmicro());
        final Computer updatedComputer = computerRepository.save(computer);
        return ResponseEntity.ok(updatedComputer);
    }
}

