package net.therap.mealplannerspring.dao;

import net.therap.mealplannerspring.domain.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author rayed
 * @since 11/16/16 1:28 PM
 */

public interface DishRepository extends JpaRepository<Dish, Integer> {
//    public Dish findById(long id);

}
