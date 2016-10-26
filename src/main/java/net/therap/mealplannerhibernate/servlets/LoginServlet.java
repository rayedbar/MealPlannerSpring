package net.therap.mealplannerhibernate.servlets;

import net.therap.mealplannerhibernate.entity.User;
import net.therap.mealplannerhibernate.service.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author rayed
 * @since 10/25/16 1:29 PM
 */

@WebServlet(name = "LoginServlet", urlPatterns = {"/Login.do"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter writer = resp.getWriter();
//        writer.write("<html><body><h1>You have reached LoginServlet</h1></body></html>");

        String inputEmail = req.getParameter("inputEmail");
        String inputPassword = req.getParameter("inputPassword");

        UserManager userManager = new UserManager();
        User user = userManager.getUser(inputEmail, inputPassword);

        if (user != null){
            HttpSession session = req.getSession();
            session.setAttribute("inputEmail", inputEmail);
            session.setAttribute("inputPassword", inputPassword);
            resp.sendRedirect("homepage.jsp");
        } else {
            resp.sendRedirect("loginerror.jsp");
        }


        //Persist to Database
    }

}
