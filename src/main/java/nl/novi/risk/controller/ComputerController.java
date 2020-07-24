package nl.novi.risk.controller;

import nl.novi.risk.domain.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @GetMapping(value = "/api/computer", produces = MediaType.APPLICATION_JSON_VALUE)
        return listComputer;
    }

    @GetMapping(value = "/api/computer/{id}")
    public Computer getComputerById(@PathVariable int id) {
        Optional<Computer> computer = computerRepository.findById(id);
        if(computer.isPresent()) {
            return computer.get();
        } else {
            return null;
        }
    }

    @PostMapping("/api/computer")
    public Computer createComputer(@Valid @RequestBody Computer computer) {
        return computerRepository.save(computer);
    }

    @DeleteMapping("/api/computer/{id}")
    public Map<String, Boolean> deleteComputer(@PathVariable(value = "id") Long computerId)
            throws ResourceNotFoundException {
        Computer computer = computerRepository.findById(Math.toIntExact(computerId))
                .orElseThrow(() -> new ResourceNotFoundException("Computer not found for this id :: " + computerId));
        computerRepository.delete(computer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/api/computer/{id}")
    public ResponseEntity<Computer> updateComputer(@PathVariable(value = "id") Long computerId,
                                                   @Valid @RequestBody Computer computerDetails) throws ResourceNotFoundException {
        Computer computer = computerRepository.findById(Math.toIntExact(computerId))
                .orElseThrow(() -> new ResourceNotFoundException("Computer not found for this id :: " + computerId));
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
        computer.setType_usb_aansluitingen(computerDetails.getType_usb_aansluitingen());
        final Computer updatedComputer = computerRepository.save(computer);
        return ResponseEntity.ok(updatedComputer);
    }
}
