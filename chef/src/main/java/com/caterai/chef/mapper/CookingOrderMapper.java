package com.caterai.chef.mapper;

import com.caterai.chef.domain.CookingOrder;
import com.caterai.chef.dto.CookingOrderDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CookingOrderMapper {

    CookingOrderDTO toDto (CookingOrder cookingOrder);

    CookingOrder toEntity (CookingOrderDTO cookingOrderDTO);

    List<CookingOrderDTO> toListDto (List<CookingOrder> cookingOrders);

}
