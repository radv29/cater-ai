package com.caterai.chef.controller;

import com.caterai.chef.dto.ChefDTO;
import com.caterai.chef.service.ChefService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChefController {

    private final Logger log = LoggerFactory.getLogger(ChefController.class);

    @Autowired
    private ChefService chefService;

    @PostMapping("/chef")
    public ResponseEntity<ChefDTO> saveChef(
            @RequestBody ChefDTO chefDTO
    ) {
        log.debug("REST request to save chef : {}", chefDTO);
        ChefDTO result = chefService.save(chefDTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/chef/{id}")
    public ResponseEntity<Void> deleteChef(@PathVariable Long id) {
        log.debug("REST request to delete chef: {}", id);
        chefService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
