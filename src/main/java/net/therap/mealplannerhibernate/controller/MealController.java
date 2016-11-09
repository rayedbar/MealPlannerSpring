package net.therap.mealplannerhibernate.controller;

import com.google.gson.Gson;
import net.therap.mealplannerhibernate.entity.Meal;
import net.therap.mealplannerhibernate.service.MealPlanner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author rayed
 * @since 11/9/16 3:21 PM
 */

@Controller
@RequestMapping("/meal")
public class MealController {

    @RequestMapping(value = "/view", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String view(){

        MealPlanner mealPlanner = new MealPlanner();

        List<Meal> meals = mealPlanner.getMeal();

        String json = new Gson().toJson(meals);

        System.out.println(json);

        return json;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("mealId") int mealId) {

        MealPlanner mealPlanner = new MealPlanner();
        mealPlanner.deleteMeal(mealId);

        return "adminHomePage";
    }

    @RequestMapping("/editMealForm")
    @ResponseBody
    public ModelAndView editMealForm(@RequestParam("mealId") int mealId, ModelAndView modelAndView){
        System.out.println(mealId);
//        modelAndView.addObject("meal", new Meal());
        modelAndView.setViewName("editMealForm");
        modelAndView.addObject("mealId", mealId);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam("mealId") int mealId, @RequestParam("mealDay") String day, @RequestParam("mealType") String type){

//        List<Dish> dishList = meal.getDishList();

//        String [] dishes = mealDishes.split(",");

//        List<Dish> dishList = new ArrayList<>();
//
//        for (String dish : dishes){
//            String name = dish.trim();
//            dishList.add(new Dish(name));
//        }

        System.out.println(mealId + " " + day + " " + type);

        MealPlanner mealPlanner = new MealPlanner();
        mealPlanner.updateMeal(mealId, day, type);

        return "adminHomePage";
    }
}
