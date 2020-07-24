package nl.novi.risk.controller;

import nl.novi.risk.domain.Computer;
import nl.novi.risk.domain.Randapparatuur;
import nl.novi.risk.domain.Software;
import nl.novi.risk.repository.RandapparatuurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class RandapparatuurController {

    @Autowired
    private RandapparatuurRepository randapparatuurRepository;

    @GetMapping(value = "/api/randapparatuur", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Randapparatuur> getRandapparatuur() {
        List<Randapparatuur> listRandapparatuur = (List<Randapparatuur>) randapparatuurRepository.findAll();
        return listRandapparatuur;
    }

    @GetMapping(value = "/api/randapparatuur/{id}")
    public Randapparatuur getRandapparatuurById(@PathVariable int id) {
        Optional<Randapparatuur> randapparatuur = randapparatuurRepository.findById(id);
        if(randapparatuur.isPresent()) {
            return randapparatuur.get();
        } else {
            return null;
        }
    }

    @PostMapping("/api/randapparatuur")
    public Randapparatuur createRandapparatuur(@Valid @RequestBody Randapparatuur randapparatuur) {
        return randapparatuurRepository.save(randapparatuur);
    }

    @DeleteMapping("/api/randaparatuur/{id}")
    public Map<String, Boolean> deleteRandapparatuur(@PathVariable(value = "id") Long randapparatuurId)
            throws ResourceNotFoundException {
        Randapparatuur randapparatuur = randapparatuurRepository.findById(Math.toIntExact(randapparatuurId))
                .orElseThrow(() -> new ResourceNotFoundException("Randapparatuur not found for this id :: " + randapparatuurId));
        randapparatuurRepository.delete(randapparatuur);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/api/randaparatuur/{id}")
    public ResponseEntity<Randapparatuur> updateRandapparatuur(@PathVariable(value = "id") Long randapparatuurId,
                                                   @Valid @RequestBody Randapparatuur randapparatuurDetails) throws ResourceNotFoundException {
        Randapparatuur randapparatuur = randapparatuurRepository.findById(Math.toIntExact(randapparatuurId))
                .orElseThrow(() -> new ResourceNotFoundException("Randapparatuur not found for this id :: " + randapparatuurId));
        randapparatuur.setSoort(randapparatuurDetails.getSoort());
        randapparatuur.setMerk(randapparatuurDetails.getMerk());
        randapparatuur.setType(randapparatuurDetails.getType());
        randapparatuur.setAfdeling(randapparatuurDetails.getAfdeling());
        randapparatuur.setLocatie(randapparatuurDetails.getLocatie());
        randapparatuur.setTypebeeldscherm(randapparatuurDetails.getTypebeeldscherm());
        randapparatuur.setFormaatbeeldscherm(randapparatuurDetails.getFormaatbeeldscherm());
        randapparatuur.setAansluitingenbeeldscherm(randapparatuurDetails.getAansluitingenbeeldscherm());
        randapparatuur.setVideokaart(randapparatuurDetails.getVideokaart());
        randapparatuur.setVideogeheugen(randapparatuurDetails.getVideogeheugen());
        randapparatuur.setAankoopdatum(randapparatuurDetails.getAankoopdatum());
        randapparatuur.setAfloopdatum(randapparatuurDetails.getAfloopdatum());
        randapparatuur.setLevnr(randapparatuurDetails.getLevnr());
        randapparatuur.setOnderhoudscontract(randapparatuurDetails.getOnderhoudscontract());
        randapparatuur.setMerkprinter(randapparatuurDetails.getMerkprinter());
        randapparatuur.setTypeprinter(randapparatuurDetails.getTypeprinter());
        final Randapparatuur updatedRandapparatuur = randapparatuurRepository.save(randapparatuur);
        return ResponseEntity.ok(updatedRandapparatuur);
    }

}
