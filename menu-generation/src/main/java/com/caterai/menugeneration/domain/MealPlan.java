package com.caterai.menugeneration.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class MealPlan {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany (cascade = CascadeType.ALL)
    private List<Meal> menu = new ArrayList<>();

    private Integer avgCalories;

}
