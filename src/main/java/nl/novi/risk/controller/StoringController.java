package nl.novi.risk.controller;

import nl.novi.risk.domain.Storing;
import nl.novi.risk.repository.StoringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class StoringController {

    @Autowired
    private StoringRepository storingRepository;

    @GetMapping(value = "/api/storing", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Storing> getStoring() {
        List<Storing> listStoring = (List<Storing>) storingRepository.findAll();
        return listStoring;
    }

    @GetMapping(value = "/api/storing/{id}")
    public Storing getStoringenById(@PathVariable int id) {
        Optional<Storing> storing = storingRepository.findById(id);
        if(storing.isPresent()) {
            return storing.get();
        } else {
            return null;
        }
    }

    @PostMapping("/api/storing")
    public Storing createStoring(@Valid @RequestBody Storing storing) {
        return storingRepository.save(storing);
    }

    @DeleteMapping("/api/storing/{id}")
    public Map<String, Boolean> deleteStoring(@PathVariable(value = "id") Long storingId)
            throws ResourceNotFoundException {
        Storing storing = storingRepository.findById(Math.toIntExact(storingId))
                .orElseThrow(() -> new ResourceNotFoundException("Storing not found for this id :: " + storingId));
        storingRepository.delete(storing);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/api/storing/{id}")
    public ResponseEntity<Storing> updateStoring(@PathVariable(value = "id") Long storingId,
                                                   @Valid @RequestBody Storing storingDetails) throws ResourceNotFoundException {
        Storing storing = storingRepository.findById(Math.toIntExact(storingId))
                .orElseThrow(() -> new ResourceNotFoundException("Storing not found for this id :: " + storingId));
        storing.setStnr(storingDetails.getStnr());
        storing.setPcrndswnr(storingDetails.getPcrndswnr());
        storing.setPrioriteit(storingDetails.getPrioriteit());
        storing.setDatumstoring(storingDetails.getDatumstoring());
        storing.setDatumstoplossing(storingDetails.getDatumstoplossing());
        storing.setKostenstoring(storingDetails.getKostenstoring());
        storing.setOmschrijvingstoring(storingDetails.getOmschrijvingstoring());
        storing.setOmschrijvingoplossing(storingDetails.getOmschrijvingoplossing());
        final Storing updatedStoring = storingRepository.save(storing);
        return ResponseEntity.ok(updatedStoring);
    }
}
