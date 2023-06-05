package com.caterai.chef.service;

import com.caterai.chef.domain.Chef;
import com.caterai.chef.domain.CookingOrder;
import com.caterai.chef.domain.enums.OrderStatus;
import com.caterai.chef.dto.CookingOrderDTO;
import com.caterai.chef.dto.IncomingOrderDTO;
import com.caterai.chef.mapper.CookingOrderMapper;
import com.caterai.chef.mapper.IncomingOrderMapper;
import com.caterai.chef.repository.CookingOrderRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CookingOrderService {

    private final CookingOrderRepository cookingOrderRepository;

    private final ChefService chefService;

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
    public CookingOrder findCookingOrderById(Long orderId) {
        return cookingOrderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found for id: " + orderId));
    }

    @Transactional
    public CookingOrderDTO cookOrder(Long orderId, Long chefId) {

        CookingOrder cookingOrder = findCookingOrderById(orderId);
        Chef chef = chefService.findChefById(chefId);

        cookingOrder.setStatus(OrderStatus.COOKED);
        cookingOrder.setAssignedChef(chef);

        cookingOrderRepository.save(cookingOrder);

        log.debug("Set status COOKED and chef for: " + cookingOrder);
        return cookingOrderMapper.toDto(cookingOrder);
    }

    @Transactional
    public List<IncomingOrderDTO> findOrderedMeals() {
        List<CookingOrder> orderedMeals = cookingOrderRepository.findCookingOrdersByStatus(OrderStatus.ORDERED);
        List<IncomingOrderDTO> orderedMealsDTO = incomingOrderMapper.toListDto(orderedMeals);

        log.debug("Returned meals with status ORDERED: " + orderedMealsDTO);

        return orderedMealsDTO;
    }

    @Transactional
    public List<CookingOrderDTO> findCookedOrdersByChef(Long chefId){
        List<CookingOrder> ordersCookedByChef = cookingOrderRepository.findCookingOrdersByAssignedChef_Id(chefId);
        return cookingOrderMapper.toListDto(ordersCookedByChef);
    }

}
