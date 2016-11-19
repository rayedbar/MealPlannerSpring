package net.therap.mealplannerspring.web.validator;

import net.therap.mealplannerspring.domain.Dish;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author rayed
 * @since 11/17/16 3:02 PM
 */

@Component
public class DishValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Dish.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "dish.name");
    }
}
