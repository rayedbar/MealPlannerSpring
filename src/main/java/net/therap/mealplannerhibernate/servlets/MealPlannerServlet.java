package net.therap.mealplannerhibernate.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author rayed
 * @since 10/24/16 4:12 PM
 */

@WebServlet(name = "MealPlannerServlet", urlPatterns = {"/MealPlanner.do"})
public class MealPlannerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>You have arrived at Meal Planner</h1>");
        writer.flush();
    }

}