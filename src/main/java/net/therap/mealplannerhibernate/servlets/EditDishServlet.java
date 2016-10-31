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
 * @since 10/31/16 12:05 PM
 */

@WebServlet(name = "EditDishServlet", urlPatterns = {"/login/editDish.do"})
public class EditDishServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getParameter("newDishName"));
//        System.out.println(req.getParameter("oldDishName"));

        String name = req.getParameter("newDishName");
        String name1 = req.getParameter("oldDishName");

        DishPlanner dishPlanner = new DishPlanner();
        dishPlanner.updateDish(name, name1);

        resp.sendRedirect(req.getContextPath() + "/AdminPage.jsp");
       // req.getRequestDispatcher(req.getContextPath() + "/AdminPage.jsp").include(req, resp);
    }
}
