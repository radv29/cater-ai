package com.caterai.menugeneration.service;

import com.caterai.menugeneration.domain.MealPlan;
import com.caterai.menugeneration.dto.MealPlanDTO;
import com.caterai.menugeneration.dto.PersonalDetailsDTO;
import com.caterai.menugeneration.mapper.MealPlanMapper;
import com.caterai.menugeneration.repository.MealPlanRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MealPlanService {

    private final GptService gptService;

    private final MealPlanMapper mealPlanMapper;

    private final MealPlanRepository mealPlanRepository;

    @Value("${promptMessageForCm}")
    private String promptMessageForCm;

    @Value("${promptMessageForFt}")
    private String promptMessageForFt;

    ObjectMapper objectMapper = new ObjectMapper();

    public MealPlanDTO generatedMealPlanDTO(PersonalDetailsDTO personalDetailsDTO) throws JsonProcessingException {
        MealPlanDTO generatedMealPlanDTO = generateMealPlan(personalDetailsDTO);

        return save(generatedMealPlanDTO);
    }

    @Transactional
    private MealPlanDTO save(MealPlanDTO mealPlanDTO) {

        MealPlan mealPlan = mealPlanMapper.toEntity(mealPlanDTO);

        mealPlan = mealPlanRepository.save(mealPlan);

        log.debug("Created meal plan object: " + mealPlan);

        return mealPlanMapper.toDto(mealPlan);
    }

    private MealPlanDTO generateMealPlan(PersonalDetailsDTO personalDetailsDTO) throws JsonProcessingException {
        String resp;

        if(personalDetailsDTO.getHeightUnit().equals("CENTIMETERS")) {
            resp = gptService.chat(formatPromptMessageForCm(personalDetailsDTO));
        } else if (personalDetailsDTO.getHeightUnit().equals("FEET")) {
            resp = gptService.chat(formatPromptMessageForFt(personalDetailsDTO));
        } else {
            resp = "No response";
        }

        return objectMapper.readValue(resp, MealPlanDTO.class);
    }

    private String formatPromptMessageForCm(PersonalDetailsDTO personalDetailsDTO) {
        return String.format(promptMessageForCm,
                personalDetailsDTO.getAge(),
                personalDetailsDTO.getGender(),
                personalDetailsDTO.getWeight(),
                personalDetailsDTO.getWeightUnit(),
                personalDetailsDTO.getHeightInCm(),
                personalDetailsDTO.getHeightUnit(),
                personalDetailsDTO.getObjective(),
                personalDetailsDTO.getNoOfMeals(),
                personalDetailsDTO.getNoOfSnacks());
    }

    private String formatPromptMessageForFt(PersonalDetailsDTO personalDetailsDTO) {
        return String.format(promptMessageForFt,
                personalDetailsDTO.getAge(),
                personalDetailsDTO.getGender(),
                personalDetailsDTO.getWeight(),
                personalDetailsDTO.getWeightUnit(),
                personalDetailsDTO.getHeightInFt(),
                personalDetailsDTO.getHeightUnit(),
                personalDetailsDTO.getHeightInIn(),
                personalDetailsDTO.getObjective(),
                personalDetailsDTO.getNoOfMeals(),
                personalDetailsDTO.getNoOfSnacks());
    }

}
