package net.therap.mealplannerhibernate.servlets;

import com.google.gson.Gson;
import net.therap.mealplannerhibernate.entity.Meal;
import net.therap.mealplannerhibernate.service.MealPlanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author rayed
 * @since 10/30/16 10:21 AM
 */

@WebServlet(name = "ViewMealServlet", urlPatterns = {"/login/getMeal.do"})
public class ViewMealServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MealPlanner mealPlanner = new MealPlanner();
        List<Meal> meal = mealPlanner.getMeal();

        String json = new Gson().toJson(meal);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
