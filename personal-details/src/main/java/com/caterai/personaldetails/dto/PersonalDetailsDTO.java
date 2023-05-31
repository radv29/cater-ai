package com.caterai.personaldetails.dto;

import com.caterai.personaldetails.domain.enums.Gender;
import com.caterai.personaldetails.domain.enums.HeightUnit;
import com.caterai.personaldetails.domain.enums.WeightUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDetailsDTO {

    private Long id;

    private Gender gender;

    private Integer age;

    private WeightUnit weightUnit;

    private Double weight;

    private HeightUnit heightUnit;

    private Integer heightInCm;

    private Integer heightInFt;

    private Integer heightInIn;

    private Integer noOfMeals;

    private Integer noOfSnacks;

    private String objective;

}
