package net.therap.mealplannerspring.web.controller;

import net.therap.mealplannerspring.domain.Meal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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
        return null;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("mealId") int mealId) {
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
        return "adminHomePage";
    }

    @RequestMapping(value = "/addMealForm", method = RequestMethod.GET)
    public String addMealForm(ModelMap map){
        return "addMealForm";
    }

    @RequestMapping("/add")
    public String add(@Valid Meal meal, BindingResult result, @RequestParam("dishList") String dishList){
        return "adminHomePage";
    }
}
