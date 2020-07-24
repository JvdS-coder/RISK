package nl.novi.risk.controller;

import nl.novi.risk.domain.Storingen;
import nl.novi.risk.repository.StoringenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class StoringenController {

    @Autowired
    private StoringenRepository storingenRepository;

    @GetMapping(value = "/api/storingen", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Storingen> getStoringen() {
        List<Storingen> listStoringen = (List<Storingen>) storingenRepository.findAll();
        return listStoringen;
    }

    @GetMapping(value = "/api/storingen/{id}")
    public Storingen getStoringenById(@PathVariable int id) {
        Optional<Storingen> storingen = storingenRepository.findById(id);
        if(storingen.isPresent()) {
            return storingen.get();
        } else {
            return null;
        }
    }

    @PostMapping("/api/storingen")
    public Storingen createStoringen(@Valid @RequestBody Storingen storingen) {
        return storingenRepository.save(storingen);
    }

    @DeleteMapping("/api/storingen/{id}")
    public Map<String, Boolean> deleteStoringen(@PathVariable(value = "id") Long storingenId)
            throws ResourceNotFoundException {
        Storingen storingen = storingenRepository.findById(Math.toIntExact(storingenId))
                .orElseThrow(() -> new ResourceNotFoundException("Storingen not found for this id :: " + storingenId));
        storingenRepository.delete(storingen);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/api/storingen/{id}")
    public ResponseEntity<Storingen> updateStoringen(@PathVariable(value = "id") Long storingenId,
                                                   @Valid @RequestBody Storingen storingenDetails) throws ResourceNotFoundException {
        Storingen storingen = storingenRepository.findById(Math.toIntExact(storingenId))
                .orElseThrow(() -> new ResourceNotFoundException("Storingen not found for this id :: " + storingenId));
        storingen.setStnr(storingenDetails.getStnr());
        storingen.setPcrndswnr(storingenDetails.getPcrndswnr());
        storingen.setPrioriteit(storingenDetails.getPrioriteit());
        storingen.setDatumstoring(storingenDetails.getDatumstoring());
        storingen.setDatumstoplossing(storingenDetails.getDatumstoplossing());
        storingen.setKostenstoring(storingenDetails.getKostenstoring());
        storingen.setOmschrijvingstoring(storingenDetails.getOmschrijvingstoring());
        storingen.setOmschrijvingoplossing(storingenDetails.getOmschrijvingoplossing());
        final Storingen updatedStoringen = storingenRepository.save(storingen);
        return ResponseEntity.ok(updatedStoringen);
    }
}
