package net.therap.mealplannerspring.service;

import net.therap.mealplannerspring.dao.DishDao;
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
    DishDao dishDao;

    public List<Dish> getDishList() {
        return dishDao.findAll();
    }

    public void deleteDish(int dishId) {
        dishDao.delete(dishId);
    }

    public void updateDish(int dishId, String dishName) {
        Dish dish = dishDao.findOne(dishId);
        dish.setName(dishName);
        dishDao.save(dish);
    }

    public void addDish(String dishName) {
        Dish dish = new Dish(dishName);
        dishDao.save(dish);
    }

    public void deleteDishList(List<Dish> dishList) {
        dishDao.deleteInBatch(dishList);
    }
}
