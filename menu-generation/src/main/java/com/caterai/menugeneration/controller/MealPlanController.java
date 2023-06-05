package com.caterai.menugeneration.controller;

import com.caterai.menugeneration.dto.MealPlanDTO;
import com.caterai.menugeneration.dto.PersonalDetailsDTO;
import com.caterai.menugeneration.service.MealPlanService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MealPlanController {

    private final Logger log = LoggerFactory.getLogger(MealPlanController.class);

    private final MealPlanService mealPlanService;

    @PostMapping("/meal-plan")
    public ResponseEntity<MealPlanDTO> getPersonalInformationById(@RequestBody PersonalDetailsDTO personalDetailsDTO) throws JsonProcessingException {
        log.debug("REST request to generate and save MealPlan : {}", personalDetailsDTO);
        MealPlanDTO result = mealPlanService.generatedMealPlanDTO(personalDetailsDTO);
        return ResponseEntity.ok().body(result);
    }

}
