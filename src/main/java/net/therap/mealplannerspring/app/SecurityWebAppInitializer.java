package net.therap.mealplannerspring.app;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @author rayed
 * @since 11/20/16 8:13 PM
 */

public class SecurityWebAppInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityWebAppInitializer() {
        super(SecurityConfig.class);
    }

}
