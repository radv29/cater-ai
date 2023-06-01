package com.caterai.chef.domain;

import com.caterai.chef.domain.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CookingOrder {

    @Id
    @GeneratedValue
    private Long id;

    @ElementCollection
    private List<String> contents;

    @ManyToOne
    @JoinColumn(name="chef_id", nullable=true)
    private Chef assignedChef;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
