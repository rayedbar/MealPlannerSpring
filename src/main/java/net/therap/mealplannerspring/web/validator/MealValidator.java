package net.therap.mealplannerspring.web.validator;

import net.therap.mealplannerspring.domain.Meal;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author rayed
 * @since 11/17/16 2:32 PM
 */

@Component
public class MealValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Meal.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "day", "meal.day");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "meal.type");
    }
}
