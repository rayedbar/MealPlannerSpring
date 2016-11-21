package net.therap.mealplannerspring.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author rayed
 * @since 11/21/16 9:40 AM
 */

@WebFilter(urlPatterns = {"/dish/*", "/meal/*", "/user/*"})
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        String userEmail = (String) session.getAttribute("email");

        if (userEmail != null) {
            chain.doFilter(request, response);
            return;
        }

        ((HttpServletResponse) response).sendRedirect("/auth/login");
    }

    @Override
    public void destroy() {

    }
}
