package nl.novi.risk.controller;

import nl.novi.risk.domain.Software;
import nl.novi.risk.repository.SoftwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class SoftwareController {

    @Autowired
    private SoftwareRepository softwareRepository;

    @GetMapping(value = "/api/software", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Software> getSoftware() {
        List<Software> listSoftware = (List<Software>) softwareRepository.findAll();
            return listSoftware;
     }

    @GetMapping(value = "/api/software/{id}")
    public Software getSoftwareById(@PathVariable int id) {
        Optional<Software> software = softwareRepository.findById(id);
        if(software.isPresent()) {
            return software.get();
        } else {
            return null;
        }
    }

    @PostMapping("/api/software")
    public Software createSoftware(@Valid @RequestBody Software software) {
        return softwareRepository.save(software);
    }

    @DeleteMapping("/api/software/{id}")
    public Map<String, Boolean> deleteSoftware(@PathVariable(value = "id") Long softwareId)
            throws ResourceNotFoundException {
        Software software = softwareRepository.findById(Math.toIntExact(softwareId))
                .orElseThrow(() -> new ResourceNotFoundException("Software not found for this id :: " + softwareId));
        softwareRepository.delete(software);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/api/software/{id}")
    public ResponseEntity<Software> updateSoftware(@PathVariable(value = "id") Long softwareId,
                                                   @Valid @RequestBody Software softwareDetails) throws ResourceNotFoundException {
        Software software = softwareRepository.findById(Math.toIntExact(softwareId))
          .orElseThrow(() -> new ResourceNotFoundException("Software not found for this id :: " + softwareId));
        software.setNaamapplicatie(softwareDetails.getNaamapplicatie());
        software.setLevnummer(softwareDetails.getLevnummer());
        software.setKlantnummer(softwareDetails.getKlantnummer());
        software.setLicentieaantal(softwareDetails.getLicentieaantal());
        software.setAfloopdatum(softwareDetails.getAfloopdatum());
        software.setMinvereistos(softwareDetails.getMinvereistos());
        software.setMinramgeheugen(softwareDetails.getMinramgeheugen());
        software.setMinopslagruimte(softwareDetails.getMinopslagruimte());
        software.setMinvideogeheugen(softwareDetails.getMinvideogeheugen());
        final Software updatedSoftware = softwareRepository.save(software);
        return ResponseEntity.ok(updatedSoftware);
    }
}
