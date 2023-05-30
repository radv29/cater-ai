package com.caterai.menugeneration.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class MealPlan {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<Menu> meals = new ArrayList<>();

    private Integer avgCalories;

}
