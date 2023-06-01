package com.caterai.chef.service;

import com.caterai.chef.domain.Chef;
import com.caterai.chef.dto.ChefDTO;
import com.caterai.chef.mapper.ChefMapper;
import com.caterai.chef.repository.ChefRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ChefService {

    private final ChefRepository chefRepository;

    private final ChefMapper chefMapper;

    @Transactional
    public ChefDTO save(ChefDTO chefDTO) {

        Chef chef = chefMapper.toEntity(chefDTO);
        chef = chefRepository.save(chef);

        log.debug("Created chef object: " + chef);

        return chefMapper.toDto(chef);
    }

    public void delete(Long id) {
        chefRepository.deleteById(id);
    }

}
