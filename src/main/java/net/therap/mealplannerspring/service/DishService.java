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

    public void delete(int dishId) {
        repository.delete(dishId);
    }
}
