package com.caterai.personaldetails.mapper;

import com.caterai.personaldetails.domain.PersonalDetails;
import com.caterai.personaldetails.dto.PersonalDetailsDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonalDetailsMapper {

    PersonalDetailsDTO toDto (PersonalDetails personalDetails);

    PersonalDetails toEntity (PersonalDetailsDTO personalDetailsDTO);

}