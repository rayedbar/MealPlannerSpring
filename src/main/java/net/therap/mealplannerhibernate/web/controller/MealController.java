package net.therap.mealplannerhibernate.web.controller;

import com.google.gson.Gson;
import net.therap.mealplannerhibernate.entity.Dish;
import net.therap.mealplannerhibernate.entity.Meal;
import net.therap.mealplannerhibernate.service.DishPlanner;
import net.therap.mealplannerhibernate.service.MealPlanner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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
        modelAndView.setViewName("editMealForm");
        modelAndView.addObject("mealId", mealId);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam("mealId") int mealId, @RequestParam("mealDay") String day, @RequestParam("mealType") String type){
        MealPlanner mealPlanner = new MealPlanner();
        mealPlanner.updateMeal(mealId, day, type);
        return "adminHomePage";
    }

    @RequestMapping(value = "/addMealForm", method = RequestMethod.GET)
    public String addMealForm(ModelMap map){
        DishPlanner dishPlanner = new DishPlanner();
        List<Dish> dish = dishPlanner.getDish();
        Meal meal = new Meal();
        meal.setDishList(dish);
        map.addAttribute("meal", meal);
        return "addMealForm";
    }

    @RequestMapping("/add")
    public String add(@Valid Meal meal, BindingResult result, @RequestParam("dishList") String dishList){
        System.out.println(meal.getDay() + " ---- " + meal.getType() );
        System.out.println(dishList);
        return "adminHomePage";
    }
}
