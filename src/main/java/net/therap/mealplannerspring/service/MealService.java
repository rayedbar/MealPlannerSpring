package net.therap.mealplannerspring.service;

import net.therap.mealplannerspring.dao.MealRepository;
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
    private MealRepository mealRepository;

    public List<Meal> getMealList() {
        return mealRepository.findAll();
    }

    public void deleteMeal(int mealId) {
        mealRepository.delete(mealId);
    }

    public void addMeal(Meal meal) {
        mealRepository.save(meal);
    }

    public Meal getMeal(int id) {
        return mealRepository.findOne(id);
    }

    public void updateMeal(Meal meal) {
        mealRepository.save(meal);
//        mealRepository.saveAndFlush(meal);
//        mealRepository.
    }
}
