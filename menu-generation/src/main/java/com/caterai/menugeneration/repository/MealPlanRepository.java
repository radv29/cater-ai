package com.caterai.menugeneration.repository;

import com.caterai.menugeneration.domain.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealPlanRepository extends JpaRepository<MealPlan, Long> {
}
