package com.caterai.menugeneration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDetailsDTO {

    private Long id;

    private String gender;

    private Integer age;

    private String weightUnit;

    private Double weight;

    private String heightUnit;

    private Integer heightInCm;

    private Integer heightInFt;

    private Integer heightInIn;

    private Integer noOfMeals;

    private Integer noOfSnacks;

    private String objective;

}

