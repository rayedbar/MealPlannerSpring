package net.therap.mealplannerhibernate.servlets;

import com.google.gson.Gson;
import net.therap.mealplannerhibernate.entity.User;
import net.therap.mealplannerhibernate.service.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author rayed
 * @since 10/30/16 2:51 PM
 */

@WebServlet(name = "ViewUserServlet", urlPatterns = {"/login/getUser.do"})
public class ViewUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserManager userManager = new UserManager();
        List<User> userList = userManager.getUserList();

        String json = new Gson().toJson(userList);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
