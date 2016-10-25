package net.therap.mealplannerhibernate.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author rayed
 * @since 10/25/16 1:17 PM
 */

@WebFilter(filterName = "UserVerificationFilter")
public class UserVerificationFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Servlet Filter arrived");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
