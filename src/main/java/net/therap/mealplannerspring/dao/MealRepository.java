package net.therap.mealplannerspring.dao;

import net.therap.mealplannerspring.domain.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rayed
 * @since 11/16/16 4:48 PM
 */

public interface MealRepository extends JpaRepository<Meal, Integer> {
}
