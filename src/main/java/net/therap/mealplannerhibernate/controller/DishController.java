package net.therap.mealplannerhibernate.controller;

import com.google.gson.Gson;
import net.therap.mealplannerhibernate.entity.Dish;
import net.therap.mealplannerhibernate.service.DishPlanner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author rayed
 * @since 11/8/16 11:42 AM
 */

@Controller
@RequestMapping(value = {"/dish"})
public class DishController {

    @ResponseBody
    @RequestMapping(value = "/view", method = RequestMethod.GET, produces = "application/json")
    public String viewDish(HttpServletResponse response) {
        DishPlanner dishPlanner = new DishPlanner();
        List<Dish> dishList = dishPlanner.getDish();

        //TODO jackson

        String json = new Gson().toJson(dishList);
        return json;
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteDish(HttpServletRequest request) {
        int dishId = Integer.parseInt(request.getParameter("dishId"));
        DishPlanner dishPlanner = new DishPlanner();
        dishPlanner.deleteDish(dishId);
        return "redirect:/usr/homepage";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editDish(HttpServletRequest request) {
        int dishId = Integer.parseInt(request.getParameter("dishId"));
        String dishName = request.getParameter("newDishName");
        DishPlanner dishPlanner = new DishPlanner();
        dishPlanner.updateDish(dishId, dishName);
        return "adminHomePage";
    }

    @RequestMapping(value = "/editDishForm", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getEditDishForm(@RequestParam("dishId") int dishId, ModelAndView modelMap) {
        modelMap.setViewName("editDishForm");
        modelMap.addObject("dishId", dishId);
        return modelMap;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@RequestParam("dishName") String dishName) {
        DishPlanner dishPlanner = new DishPlanner();
        dishPlanner.addDish(dishName);
        return "adminHomePage";
    }

    @RequestMapping("/addDishForm")
    public String addDishForm() {
        return "addDishForm";
    }
}