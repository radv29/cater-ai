package com.caterai.menugeneration.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "menu")
public class Meal {

    @Id
    @GeneratedValue
    private Long id;

    private String mealName;

    @ElementCollection
    private List<String> contents;

}
