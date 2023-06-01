package com.caterai.chef.mapper;

import com.caterai.chef.domain.CookingOrder;
import com.caterai.chef.dto.IncomingOrderDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IncomingOrderMapper {

    IncomingOrderDTO toDto (CookingOrder cookingOrder);

    CookingOrder toEntity (IncomingOrderDTO incomingOrderDTO);

    List<IncomingOrderDTO> toListDto (List<CookingOrder> cookingOrders);

}
