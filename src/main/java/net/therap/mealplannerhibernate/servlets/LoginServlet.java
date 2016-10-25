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
 * @since 10/25/16 1:29 PM
 */

@WebServlet(name = "LoginServlet", urlPatterns = {"/Login.do"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
//        resp.sendRedirect("login.jsp");
        String inputEmail = req.getParameter("inputEmail");
        String inputPassword= req.getParameter("inputPassword");
        System.out.println(inputEmail);
        System.out.println(inputPassword);

    }
}
