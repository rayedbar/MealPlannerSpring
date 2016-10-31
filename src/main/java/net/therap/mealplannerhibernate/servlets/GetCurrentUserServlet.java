package net.therap.mealplannerhibernate.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author rayed
 * @since 10/30/16 3:27 PM
 */

@WebServlet(name = "GetCurrentUserServlet", urlPatterns = {"/login/getCurrentUser.do"})
public class GetCurrentUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String inputEmail = (String) request.getSession().getAttribute("inputEmail");

        response.setCharacterEncoding("UTF-8");
        //response.setContentType("text");
        response.getWriter().write(inputEmail);

    }
}
