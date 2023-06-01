package com.caterai.chef.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Chef {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer completedOrders;

    @OneToMany(mappedBy = "assignedChef")
    private List<CookingOrder> ordersCooked;

}
