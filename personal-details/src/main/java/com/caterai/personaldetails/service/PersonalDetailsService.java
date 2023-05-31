package com.caterai.personaldetails.service;

import com.caterai.personaldetails.domain.PersonalDetails;
import com.caterai.personaldetails.dto.PersonalDetailsDTO;
import com.caterai.personaldetails.mapper.PersonalDetailsMapper;
import com.caterai.personaldetails.repository.PersonalDetailsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class PersonalDetailsService {

    private final PersonalDetailsRepository personalDetailsRepository;

    private final PersonalDetailsMapper personalDetailsMapper;

    @Transactional
    public PersonalDetailsDTO save(PersonalDetailsDTO personalDetailsDTO) {

        PersonalDetails personalDetails = personalDetailsMapper.toEntity(personalDetailsDTO);
        personalDetails = personalDetailsRepository.save(personalDetails);

        log.debug("Created personal details object: " + personalDetails);

        return personalDetailsMapper.toDto(personalDetails);
    }

    @Transactional
    public Optional<PersonalDetailsDTO> findById(Long id) {
        return personalDetailsRepository.findById(id).map(personalDetailsMapper::toDto);
    }

    public void delete(Long id) {
        personalDetailsRepository.deleteById(id);
    }

}
