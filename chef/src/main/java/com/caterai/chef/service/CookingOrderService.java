package com.caterai.chef.service;

import com.caterai.chef.domain.Chef;
import com.caterai.chef.domain.CookingOrder;
import com.caterai.chef.domain.enums.OrderStatus;
import com.caterai.chef.dto.CookingOrderDTO;
import com.caterai.chef.dto.IncomingOrderDTO;
import com.caterai.chef.mapper.CookingOrderMapper;
import com.caterai.chef.mapper.IncomingOrderMapper;
import com.caterai.chef.repository.ChefRepository;
import com.caterai.chef.repository.CookingOrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CookingOrderService {

    private final CookingOrderRepository cookingOrderRepository;

    private final ChefRepository chefRepository;

    private final CookingOrderMapper cookingOrderMapper;

    private final IncomingOrderMapper incomingOrderMapper;

    @Transactional
    public CookingOrderDTO saveAndOrder(IncomingOrderDTO incomingOrderDTO) {
        CookingOrder cookingOrder = incomingOrderMapper.toEntity(incomingOrderDTO);
        cookingOrder.setStatus(OrderStatus.ORDERED);
        cookingOrderRepository.save(cookingOrder);

        log.debug("Saved order and set status to ORDERED: " + cookingOrder);

        return cookingOrderMapper.toDto(cookingOrder);
    }

    @Transactional
    public CookingOrderDTO cookOrder(Long orderId, Long chefId) {
        Optional<CookingOrder> cookingOrder = cookingOrderRepository.findById(orderId);
        Optional<Chef> chef = chefRepository.findById(chefId);
        if(cookingOrder.isPresent()) {
            cookingOrder.get().setStatus(OrderStatus.COOKED);
            cookingOrder.get().setAssignedChef(chef.get());
            cookingOrderRepository.save(cookingOrder.get());

            log.debug("Set status COOKED and chef for: " + cookingOrder);
            return cookingOrderMapper.toDto(cookingOrder.get());
        } else {
            throw new NullPointerException();
        }
    }

    @Transactional
    public List<IncomingOrderDTO> findOrderedMeals() {
        List<CookingOrder> orderedMeals = cookingOrderRepository.findCookingOrdersByStatus(OrderStatus.ORDERED);
        List<IncomingOrderDTO> orderedMealsDTO = incomingOrderMapper.toListDto(orderedMeals);

        log.debug("Returned meals with status ORDERED: " + orderedMealsDTO);

        return orderedMealsDTO;
    }

}
