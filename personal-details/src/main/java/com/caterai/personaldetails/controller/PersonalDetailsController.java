package com.caterai.personaldetails.controller;

import com.caterai.personaldetails.dto.PersonalDetailsDTO;
import com.caterai.personaldetails.service.PersonalDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonalDetailsController {

    private final Logger log = LoggerFactory.getLogger(PersonalDetailsController.class);

    @Autowired
    private PersonalDetailsService personalDetailsService;

    @PostMapping("/personal-details")
    public ResponseEntity<PersonalDetailsDTO> savePersonalInformations(
            @RequestBody PersonalDetailsDTO personalDetailsDTO
    ) {
        log.debug("REST request to save PersonalDetails : {}", personalDetailsDTO);
        PersonalDetailsDTO result = personalDetailsService.save(personalDetailsDTO);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/personal-details/{id}")
    public ResponseEntity<PersonalDetailsDTO> getPersonalInformationById(@PathVariable Long id) {
        Optional<PersonalDetailsDTO> personalDetailsDTO = personalDetailsService.findById(id);
        return personalDetailsDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PutMapping("/personal-details")
    public ResponseEntity<PersonalDetailsDTO> updatePersonalDetails(
            @RequestBody PersonalDetailsDTO personalDetailsDTO
    ) {
      log.debug("REST request to update PersonalDetails: {}", personalDetailsDTO);
      PersonalDetailsDTO result = personalDetailsService.save(personalDetailsDTO);
      return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/personal-details/{id}")
    public ResponseEntity<Void> deletePersonalDetails(@PathVariable Long id) {
        log.debug("REST request to delete PersonalDetails: {}", id);
        personalDetailsService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
