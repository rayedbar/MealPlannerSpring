package net.therap.mealplannerspring.service;

import net.therap.mealplannerspring.dao.DishRepository;
import net.therap.mealplannerspring.domain.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rayed
 * @since 11/16/16 1:25 PM
 */

@Service
public class DishService {

    @Autowired
    DishRepository dishRepository;

    public List<Dish> getDishList() {
        return dishRepository.findAll();
    }

    public void deleteDish(int dishId) {
        dishRepository.delete(dishId);
    }

    public void editDish(int dishId, String dishName) {
        Dish dish = dishRepository.findOne(dishId);
        dish.setName(dishName);
        dishRepository.save(dish);
    }

    public void addDish(String dishName) {
        Dish dish = new Dish(dishName);
        dishRepository.save(dish);
    }

    public void deleteDishList(List<Dish> dishList) {
        dishRepository.deleteInBatch(dishList);
    }
}
