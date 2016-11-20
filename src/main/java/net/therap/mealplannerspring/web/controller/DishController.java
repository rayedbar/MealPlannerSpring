package net.therap.mealplannerspring.web.controller;

import net.therap.mealplannerspring.domain.Dish;
import net.therap.mealplannerspring.service.DishService;
import net.therap.mealplannerspring.web.validator.DishValidator;
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

import java.util.List;

/**
 * @author rayed
 * @since 11/8/16 11:42 AM
 */

@Controller
@RequestMapping(value = {"/dish"})
public class DishController {

    @Autowired
    private DishService dishService;

    @Autowired
    private DishValidator dishValidator;

    @InitBinder
    private void setDishValidator(WebDataBinder binder) {
        binder.addValidators(dishValidator);
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String viewDish(Model model) {
        List<Dish> dishList = dishService.getDishList();
        model.addAttribute("dishList", dishList);
        return "viewDishPage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addDish(@Validated Dish dish, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addDishPage";
        }
        dishService.addDish(dish.getName());
        return "redirect:/dish/view";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteDish(@RequestParam("id") int dishId) {
        dishService.deleteDish(dishId);
        return "redirect:/dish/view";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateDish(@RequestParam("dishId") int dishId, @RequestParam("dishName") String dishName) {
        dishService.updateDish(dishId, dishName);
        return "redirect:/dish/view";
    }

    @RequestMapping(value = "/addDishPage", method = RequestMethod.GET)
    public String addDishPage(Model model) {
        model.addAttribute("dish", new Dish());
        return "addDishPage";
    }

    @RequestMapping(value = "/updateDishPage", method = RequestMethod.GET)
    public String updateDishPage(@RequestParam("id") int dishId, Model model){
//        List<Dish> dishList = dishService.getDishList();
        model.addAttribute("dishId", dishId);
        return "updateDishPage";
    }
}