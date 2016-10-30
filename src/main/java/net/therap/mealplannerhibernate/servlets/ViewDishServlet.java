package net.therap.mealplannerhibernate.servlets;

import com.google.gson.Gson;
import net.therap.mealplannerhibernate.entity.Dish;
import net.therap.mealplannerhibernate.service.DishPlanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author rayed
 * @since 10/24/16 4:12 PM
 */

@WebServlet(name = "ViewDishServlet", urlPatterns = {"/login/viewDish.do"})
public class ViewDishServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entered Home Page");
        //String homePageRadio = request.getParameter("homePageRadio");

        DishPlanner dishPlanner = new DishPlanner();

            List<Dish> dishList = dishPlanner.viewDish();
//            request.setAttribute("dishList", dishList);
//            request.getRequestDispatcher("/viewDishList.jsp").include(request,response);

        String json = new Gson().toJson(dishList);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

}