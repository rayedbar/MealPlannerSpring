package net.therap.mealplannerspring.service;

import net.therap.mealplannerspring.dao.MealDao;
import net.therap.mealplannerspring.domain.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rayed
 * @since 11/16/16 4:49 PM
 */

@Service
public class MealService {

    @Autowired
    private MealDao mealDao;

    public List<Meal> getMealList() {
        return mealDao.findAll();
    }

    public void deleteMeal(int mealId) {
        mealDao.delete(mealId);
    }

    public void addMeal(Meal meal) {
        mealDao.save(meal);
    }

    public Meal getMeal(int id) {
        return mealDao.findOne(id);
    }

    public void updateMeal(Meal meal) {
        mealDao.save(meal);
    }
}
