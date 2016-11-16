package net.therap.mealplannerspring.app;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author rayed
 * @since 11/15/16 10:09 AM
 */

@Configuration
@ComponentScan(basePackages = "net.thera.mealplannerspring",
    excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
    })
public class RootConfig { }
