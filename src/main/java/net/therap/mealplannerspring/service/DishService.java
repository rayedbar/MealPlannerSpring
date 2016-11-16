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
    DishRepository repository;

    public List<Dish> getDishList(){
        return repository.findAll();
    }

    public void deleteDish(int dishId) {
        repository.delete(dishId);
    }

    public void editDish(int dishId, String dishName) {
        Dish dish = repository.findOne(dishId);
        dish.setName(dishName);
        repository.save(dish);
    }

    public void addDish(String dishName) {
        Dish dish = new Dish(dishName);
        repository.save(dish);
    }
}
