package net.therap.mealplannerhibernate.servlets;

import net.therap.mealplannerhibernate.service.MealPlanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author rayed
 * @since 11/1/16 3:59 PM
 */

@WebServlet(name = "DeleteMealServlet", urlPatterns = {"/login/deleteMeal.do"})
public class DeleteMealServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String day = request.getParameter("day");
        String type = request.getParameter("type");
        String dishes = request.getParameter("dishes");

        MealPlanner mealPlanner = new MealPlanner();
        mealPlanner.deleteMeal(day, type, dishes);

        //TODO
    }
}
