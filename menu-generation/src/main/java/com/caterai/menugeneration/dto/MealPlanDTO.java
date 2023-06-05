package com.caterai.menugeneration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealPlanDTO {

    private Long id;

    private List<MealDTO> menu = new ArrayList<>();

    private Integer avgCalories;

}
