package nl.novi.risk.controller;

import nl.novi.risk.domain.Computer;
import nl.novi.risk.repository.ComputerRepository;
import nl.novi.risk.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ComputerController {

    @Autowired
    private ComputerService computerService;
    private Object iMessageResolver;
    public JpaRepository<T, Integer> computerRepository;

    @GetMapping(value = "/api/computer", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Computer> getAllComputers() {
        List<Computer> computersFromDatabase = computerService.getComputers();
        return computersFromDatabase;
    }

    @GetMapping(value = "/api/computer/{id}")
    public Computer getComputerById(@PathVariable int id) {
        return computerService.getComputerById(id);
    }

    @PostMapping("/api/computer")
    public Computer createComputer(@Valid @RequestBody Computer computer) {
        return computerService.createComputer(computer);
    }

    @DeleteMapping("/api/computer/{id}")
    public String deleteComputer(@PathVariable(value = "id") int computerId) {
        return computerService.deleteComputer(computerId);
    }

    @PutMapping("/api/computer/{id}")
    public ResponseEntity<Computer> updateComputer(@PathVariable(value = "id") int computerId,
                                                   @Valid @RequestBody Computer computerDetails) throws ResourceNotFoundException {
        Computer computer = computerService.findById(computerId);
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
