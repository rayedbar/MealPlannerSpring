package net.therap.mealplannerhibernate.util;

import net.therap.mealplannerhibernate.entity.Dish;
import net.therap.mealplannerhibernate.entity.Meal;

import java.util.List;

/**
 * @author rayed
 * @since 10/20/16 1:32 PM
 */

public class Display {

    public static void displayDish(List<Dish> dishList){
        int i = 1;
        System.out.println("List of available dishes");
        System.out.println("========================");
        for (Dish dish : dishList){
            System.out.println(i + ". " + dish.getName());
            i++;
        }
    }

    public static void diplayMealByType(List<Meal> list) {
        for (Meal meal : list) {
            System.out.println(meal.getDay().toUpperCase());
            System.out.println(meal.getDishList() + "\n");
        }
    }
}
