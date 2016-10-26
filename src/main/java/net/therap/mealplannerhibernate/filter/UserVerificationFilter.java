package net.therap.mealplannerhibernate.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author rayed
 * @since 10/25/16 1:17 PM
 */

@WebFilter(filterName = "UserVerificationFilter", urlPatterns = {"homepage.jsp"})
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
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        HttpSession session = httpServletRequest.getSession();
        String inputEmail = (String) session.getAttribute("inputEmail");
        String inputPassword = (String) session.getAttribute("inputPassword");

        if (inputEmail != null && inputPassword != null){
            chain.doFilter(request, response);
        } else {
            response.getWriter().write("<html><body><h1>Log In First</h1></body></html>");
        }
    }

    @Override
    public void destroy() {

    }
}
