package com.caterai.chef.controller;

import com.caterai.chef.dto.CookingOrderDTO;
import com.caterai.chef.dto.IncomingOrderDTO;
import com.caterai.chef.service.CookingOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CookingOrderController {

    private final Logger log = LoggerFactory.getLogger(CookingOrderController.class);

    @Autowired
    private CookingOrderService cookingOrderService;

    @PostMapping("/order")
    public ResponseEntity<CookingOrderDTO> orderCookingOrder(
            @RequestBody IncomingOrderDTO incomingOrderDTO
    ) {
        log.debug("REST request to save order and set status to ORDERED : {}", incomingOrderDTO);
        CookingOrderDTO result = cookingOrderService.saveAndOrder(incomingOrderDTO);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/{orderId}/{chefId}/cook")
    public ResponseEntity<CookingOrderDTO> cookOrder(
            @PathVariable Long orderId,
            @PathVariable Long chefId
    ) {
        log.debug("REST request to set status of order to COOKED : {}", orderId);
        CookingOrderDTO result = cookingOrderService.cookOrder(orderId, chefId);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/ordered-meals")
    public ResponseEntity<List<IncomingOrderDTO>> getOrderedMeals() {
        List<IncomingOrderDTO> uncookedOrdersDTO = cookingOrderService.findOrderedMeals();
        return ResponseEntity.ok(uncookedOrdersDTO);
    }

    @GetMapping("/cooked-meals/{chefId}")
    public ResponseEntity<List<CookingOrderDTO>> getCookedOrdersByChef(@PathVariable Long chefId) {
        List<CookingOrderDTO> cookedMealsDTO = cookingOrderService.findCookedOrdersByChef(chefId);
        return ResponseEntity.ok(cookedMealsDTO);
    }

}
