package com.caterai.chef.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChefDTO {

    private Long id;

    private String name;

    private Integer completedOrders;

    private List<CookingOrderDTO> ordersCooked;

}
