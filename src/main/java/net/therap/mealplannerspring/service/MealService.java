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
    private MealRepository repository;

    public List<Meal> getMealList() {
        return repository.findAll();
    }

    public void deleteMeal(int mealId) {
        repository.delete(mealId);
    }
}
