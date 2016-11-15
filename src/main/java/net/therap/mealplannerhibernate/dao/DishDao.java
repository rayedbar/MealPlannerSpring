package net.therap.mealplannerhibernate.dao;

import net.therap.mealplannerhibernate.entity.Dish;

import java.util.List;

/**
 * @author rayed
 * @since 11/14/16 11:43 AM
 */

public interface DishDao {
    public List<Dish> viewDish();
    public void addDish(Dish dish);
    public void deleteDish(int id);
}
