package com.caterai.chef.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Chef {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer completedOrders;

}
