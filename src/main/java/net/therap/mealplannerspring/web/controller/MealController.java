package net.therap.mealplannerspring.web.controller;

import net.therap.mealplannerspring.domain.Meal;
import net.therap.mealplannerspring.service.DishService;
import net.therap.mealplannerspring.service.MealService;
import net.therap.mealplannerspring.web.validator.MealValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @Autowired
    private MealValidator mealValidator;

    @InitBinder
    private void setMealValidator(WebDataBinder binder) {
        binder.addValidators(mealValidator);
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(Model model) {
        List<Meal> mealList = mealService.getMealList();
        model.addAttribute("mealList", mealList);
        return "viewMealPage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addMeal(@Validated Meal meal, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", meal);
            return "redirect:/meal/addMealPage";
        }
        mealService.addMeal(meal);
        return "redirect:/meal/view";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteMeal(@RequestParam("id") int mealId) {
        mealService.deleteMeal(mealId);
        return "redirect:/meal/view";
    }

    @RequestMapping(value = "/addMealPage", method = RequestMethod.GET)
    public String addMealPage(Model model) {
//        if (errors.hasErrors()){
//            model.addAttribute("errors", errors);
//        }

        BindingResult errors = (BindingResult) model.asMap().get("errors");


        Meal meal = new Meal();
        meal.setDishList(dishService.getDishList());
        model.addAttribute("meal", meal);
        return "addMealPage";
    }
}
