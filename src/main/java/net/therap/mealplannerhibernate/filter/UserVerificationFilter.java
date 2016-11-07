package net.therap.mealplannerhibernate.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author rayed
 * @since 10/25/16 1:17 PM
 */

@WebFilter(filterName = "UserVerificationFilter", urlPatterns = {"/usr/*"})
public class UserVerificationFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Servlet Filter arrived");

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        //HttpServletResponse httpServletResponse = (HttpServletResponse) response;

//        HttpSession session = httpServletRequest.getSession();

        String inputEmail = httpServletRequest.getParameter("inputEmail");

//        String inputEmail = (String) session.getAttribute("inputEmail");

        System.out.println(inputEmail);
        //String inputPassword = (String) session.getAttribute("inputPassword");

        if (inputEmail != null){
            chain.doFilter(request, response);
            //request.getRequestDispatcher("/usr/homepage").include(request, response);
        } else {
            response.getWriter().write("<h1>Log In First</h1>");
        }
    }

    @Override
    public void destroy() {

    }
}
