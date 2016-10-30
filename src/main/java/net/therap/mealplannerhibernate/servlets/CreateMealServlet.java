package net.therap.mealplannerhibernate.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author rayed
 * @since 10/30/16 1:30 PM
 */

@WebServlet(name = "CreateMealServlet", urlPatterns = "/login/createMeal.do")
public class CreateMealServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("Arrived at CREATEMEAL.DO");
        request.getRequestDispatcher("createMealForm.jsp").include(request, response);
    }
}
