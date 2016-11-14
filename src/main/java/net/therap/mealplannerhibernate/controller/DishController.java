package net.therap.mealplannerhibernate.controller;

import net.therap.mealplannerhibernate.service.DishPlanner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author rayed
 * @since 11/8/16 11:42 AM
 */

@Controller
@RequestMapping(value = {"/dish"})
public class DishController {

//    @Autowired
//    DishRepository repository;

    @ResponseBody
    @RequestMapping(value = "/view", method = RequestMethod.GET, produces = "application/json")
    public String viewDish() {
//        List<Dish> dishList = (List<Dish>) repository.findAll();
//        //TODO jackson
//        String json = new Gson().toJson(dishList);
//        return json;
        return "adminHomePage";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteDish(@RequestParam("dishId") int dishId) {
//        repository.delete((long) dishId);
        return "redirect:/usr/homepage";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editDish(HttpServletRequest request) {
        int dishId = Integer.parseInt(request.getParameter("dishId"));
        String dishName = request.getParameter("newDishName");

//        Dish dish = repository.findById((long) dishId);
//        DishPlanner dishPlanner = new DishPlanner();
//        dishPlanner.updateDish(dishId, dishName);
//        dish.setName(dishName);
//        repository.save(dish);
//
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