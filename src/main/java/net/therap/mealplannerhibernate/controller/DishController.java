package net.therap.mealplannerhibernate.controller;

import com.google.gson.Gson;
import net.therap.mealplannerhibernate.entity.Dish;
import net.therap.mealplannerhibernate.service.DishPlanner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author rayed
 * @since 11/8/16 11:42 AM
 */

@Controller
@RequestMapping("/usr/homepage")
public class DishController {

    @ResponseBody
    @RequestMapping(value = "/viewDish", method = RequestMethod.GET, produces = "application/json")
    public String viewDish(HttpServletResponse response){
        DishPlanner dishPlanner = new DishPlanner();

        System.out.println("Entered viewDish");

        List<Dish> dishList = dishPlanner.getDish();
//            request.setAttribute("dishList", dishList);
//            request.getRequestDispatcher("/viewDishList.jsp").include(request,response);

        System.out.println(dishList);

        String json = new Gson().toJson(dishList);
//        response.setContentType("application/json");
//        response.setCharacterEncoding("UTF-8");
//        try {
//            response.getWriter().write(json);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return json;
    }


    @RequestMapping(value = "/deleteDish", method = RequestMethod.GET)
    public String deleteDish(HttpServletRequest request){
        int dishId = Integer.parseInt(request.getParameter("dishId"));
        DishPlanner dishPlanner = new DishPlanner();
        dishPlanner.deleteDish(dishId);
//        System.out.println(dishId);
        return "redirect:/usr/homepage";
    }

    @RequestMapping(value = "/editDish", method = RequestMethod.POST)
    public String editDish(HttpServletRequest request){
        String dishId = request.getParameter("param");
        System.out.println(dishId);
        return null;
    }

    @RequestMapping(value = "/editDishForm", method = RequestMethod.GET)
    public String getEditDishForm(@PathVariable int dishId){
        return "editDishForm";
    }
}
