package com.caterai.menugeneration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealDTO {

    private Long id;

    private String mealName;

    private List<String> contents;

}
