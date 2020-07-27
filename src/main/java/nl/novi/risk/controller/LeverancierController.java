package nl.novi.risk.controller;

import nl.novi.risk.domain.Leverancier;
import nl.novi.risk.repository.LeverancierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class LeverancierController {

    @Autowired
    private LeverancierRepository leverancierRepository;

    @GetMapping(value = "/api/leverancier", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Leverancier> getLeverancier() {
        List<Leverancier> listLeverancier = (List<Leverancier>) leverancierRepository.findAll();
        return listLeverancier;
    }

    @GetMapping(value = "/api/leverancier/{id}")
    public Leverancier getLeverancierById(@PathVariable int id) {
        Optional<Leverancier> leverancier = leverancierRepository.findById(id);
        if (leverancier.isPresent()) {
            return leverancier.get();
        } else {
            return null;
        }
    }

    @PostMapping("/api/leverancier")
    public Leverancier createLeverancier(@Valid @RequestBody Leverancier leverancier) {
        return leverancierRepository.save(leverancier);
    }

    @DeleteMapping("/api/leverancier/{id}")
    public Map<String, Boolean> deleteLeverancier(@PathVariable(value = "id") Long leverancierId)
            throws ResourceNotFoundException {
        Leverancier leverancier = leverancierRepository.findById(Math.toIntExact(leverancierId))
                .orElseThrow(() -> new ResourceNotFoundException("Leverancier not found for this id :: " + leverancierId));
        leverancierRepository.delete(leverancier);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/api/leverancier/{id}")
    public ResponseEntity<Leverancier> updateLeverancier(@PathVariable(value = "id") Long leverancierId,
                                                   @Valid @RequestBody Leverancier leverancierDetails) throws ResourceNotFoundException {
        Leverancier leverancier = leverancierRepository.findById(Math.toIntExact(leverancierId))
                .orElseThrow(() -> new ResourceNotFoundException("Leverancier not found for this id :: " + leverancierId));
        leverancier.setNaam(leverancierDetails.getNaam());
        leverancier.setAdres(leverancierDetails.getAdres());
        leverancier.setPostcode(leverancierDetails.getPostcode());
        leverancier.setVestigingsplaats(leverancierDetails.getVestigingsplaats());
        leverancier.setProvincie_state(leverancierDetails.getProvincie_state());
        leverancier.setLand_country(leverancierDetails.getLand_country());
        leverancier.setTelefoonleverancier(leverancierDetails.getTelefoonleverancier());
        leverancier.setEmailleverancier(leverancierDetails.getEmailleverancier());
        final Leverancier updatedLeverancier = leverancierRepository.save(leverancier);
        return ResponseEntity.ok(updatedLeverancier);
    }
}