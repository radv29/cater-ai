package com.caterai.chef.dto;

import com.caterai.chef.domain.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CookingOrderDTO {

    private Long id;

    private List<String> contents;

    private ChefDTO assignedChef;

    private OrderStatus status;

}
