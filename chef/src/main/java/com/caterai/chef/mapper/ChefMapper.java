package com.caterai.chef.mapper;

import com.caterai.chef.domain.Chef;
import com.caterai.chef.dto.ChefDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChefMapper {

    ChefDTO toDto (Chef chef);

    Chef toEntity (ChefDTO chefDTO);

}
