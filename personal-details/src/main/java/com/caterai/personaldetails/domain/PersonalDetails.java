package com.caterai.personaldetails.domain;

import com.caterai.personaldetails.domain.enums.Gender;
import com.caterai.personaldetails.domain.enums.HeightUnit;
import com.caterai.personaldetails.domain.enums.WeightUnit;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PersonalDetails {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private WeightUnit weightUnit;

    private Double weight;

    @Enumerated(EnumType.STRING)
    private HeightUnit heightUnit;

    private Integer heightInCm;

    private Integer heightInFt;

    private Integer heightInIn;

    private Integer noOfMeals;

    private Integer noOfSnacks;

    private String objective;

}
