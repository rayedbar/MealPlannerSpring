package net.therap.mealplannerhibernate.servlets;

import net.therap.mealplannerhibernate.service.DishPlanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author rayed
 * @since 10/31/16 3:16 PM
 */

@WebServlet(name = "AddDishServlet", urlPatterns = {"/login/addDish.do"})
public class AddDishServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addDish = request.getParameter("addDish");

        DishPlanner dishPlanner = new DishPlanner();
        dishPlanner.addDish(addDish);

        response.sendRedirect(request.getContextPath() +  "/adminHomePage.jsp");
    }
}
