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
 * @since 10/30/16 4:48 PM
 */

@WebServlet(name = "DeleteDishServlet", urlPatterns = {"/login/deleteDish.do"})
public class DeleteDishServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dishName = request.getParameter("dish_name");
        System.out.println(dishName);

        DishPlanner dishPlanner = new DishPlanner();
        dishPlanner.deleteDish(dishName);
    }
}
