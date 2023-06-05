package com.caterai.chef.repository;

import com.caterai.chef.domain.CookingOrder;
import com.caterai.chef.domain.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CookingOrderRepository extends JpaRepository<CookingOrder, Long> {

    List<CookingOrder> findCookingOrdersByStatus(OrderStatus orderStatus);

    List<CookingOrder> findCookingOrdersByAssignedChef_Id(Long chefId);

}
