package net.therap.mealplannerhibernate.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author rayed
 * @since 10/25/16 1:17 PM
 */

//@WebFilter(filterName = "UserVerificationFilter", urlPatterns = {"/usr/*"})
public class UserVerificationFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String inputEmail = httpServletRequest.getParameter("inputEmail");
        if (inputEmail != null){
            chain.doFilter(request, response);
        } else {
            response.getWriter().write("<h1>Log In First</h1>");
        }
    }

    @Override
    public void destroy() {

    }
}
