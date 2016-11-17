package net.therap.mealplannerspring.web.controller;

import com.google.gson.Gson;
import net.therap.mealplannerspring.domain.Dish;
import net.therap.mealplannerspring.domain.Meal;
import net.therap.mealplannerspring.service.DishService;
import net.therap.mealplannerspring.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
* @author rayed
* @since 11/9/16 3:21 PM
*/

@Controller
@RequestMapping("/meal")
public class MealController {

    @Autowired
    private MealService mealService;

    @Autowired
    private DishService dishService;

    @RequestMapping(value = "/view", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String view(){
        List<Meal> mealList = mealService.getMealList();
        String json = new Gson().toJson(mealList);
        return json;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("mealId") int mealId) {
        mealService.deleteMeal(mealId);
        return "adminHomePage";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam("mealId") int mealId, @RequestParam("mealDay") String day, @RequestParam("mealType") String type){
        return "adminHomePage";
    }

    @RequestMapping("/add")
    public String add(@Validated @ModelAttribute("meal") Meal meal, BindingResult bindingResult){
        mealService.addMeal(meal.getDay(), meal.getType(), meal.getDishList());
//        List<String> jsonResponse = new ArrayList<>();
//        String json = "No Errors";
//        if (bindingResult.hasErrors()) {
//            jsonResponse.add(bindingResult.getErrorCount() + "");
//            json = new Gson().toJson(jsonResponse);
//            return json;
////            return "redirect:/meal/addMealForm";
//        } else {
//            return json;
//        }
        return "adminHomePage";
    }

    @RequestMapping(value = "/addMealForm", method = RequestMethod.GET)
    public String addMealForm(Model map){
        Meal meal = new Meal();
        List<Dish> dishList = dishService.getDishList();
        map.addAttribute("meal", meal);
        map.addAttribute("dishList", dishList);
        return "addMealForm";
    }

    @RequestMapping("/editMealForm")
    @ResponseBody
    public ModelAndView editMealForm(@RequestParam("mealId") int mealId, ModelAndView modelAndView){
        modelAndView.setViewName("editMealForm");
        modelAndView.addObject("mealId", mealId);
        return modelAndView;
    }
}
