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
 * @since 11/1/16 2:51 PM
 */

@WebServlet(name = "AddMealServlet", urlPatterns = {"/login/addMeal.do"})
public class AddMealServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String enterDay = request.getParameter("enterDay");
        String enterType = request.getParameter("enterType");
        String enterDish = request.getParameter("enterDish");

        MealPlanner mealPlanner = new MealPlanner();

        mealPlanner.addMeal(enterDay, enterType, enterDish);

        response.sendRedirect(request.getContextPath() +  "/adminHomePage.jsp");
    }
}
