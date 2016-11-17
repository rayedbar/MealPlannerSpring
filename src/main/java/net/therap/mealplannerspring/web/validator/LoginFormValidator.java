package net.therap.mealplannerspring.web.validator;


import net.therap.mealplannerspring.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author rayed
 * @since 11/15/16 11:40 AM
 */

@Component
public class LoginFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
//        System.out.println(clazz.getSimpleName());
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
    }
}
