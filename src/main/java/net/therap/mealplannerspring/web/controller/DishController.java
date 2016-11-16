package net.therap.mealplannerspring.web.controller;

import com.google.gson.Gson;
import net.therap.mealplannerspring.domain.Dish;
import net.therap.mealplannerspring.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    @ResponseBody
    @RequestMapping(value = "/view", method = RequestMethod.GET, produces = "application/json")
    public String viewDish() {
        List<Dish> dishList = dishService.getDishList();
        String json = new Gson().toJson(dishList);
        return json;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteDish(@RequestParam("dishId") int dishId) {
        dishService.deleteDish(dishId);
        return "redirect:/admin/homepage";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editDish(@RequestParam("dishId") int dishId, @RequestParam("dishName") String dishName) {
        dishService.editDish(dishId, dishName);
        return "adminHomePage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam("dishName") String dishName) {
        dishService.addDish(dishName);
        return "adminHomePage";
    }

    @RequestMapping(value = "/editDishForm", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getEditDishForm(@RequestParam("dishId") int dishId, ModelAndView modelMap) {
        modelMap.setViewName("editDishForm");
        modelMap.addObject("dishId", dishId);
        return modelMap;
    }

    @RequestMapping("/addDishForm")
    public String addDishForm() {
        return "addDishForm";
    }
}