package com.caterai.menugeneration.mapper;

import com.caterai.menugeneration.domain.MealPlan;
import com.caterai.menugeneration.dto.MealPlanDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MealPlanMapper {

    MealPlanDTO toDto (MealPlan mealPlan);

    MealPlan toEntity (MealPlanDTO mealPlanDTO);

}
