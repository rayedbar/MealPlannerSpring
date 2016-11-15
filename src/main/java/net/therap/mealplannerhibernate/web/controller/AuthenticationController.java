package net.therap.mealplannerhibernate.web.controller;

import net.therap.mealplannerhibernate.entity.User;
import net.therap.mealplannerhibernate.web.validator.LoginFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author rayed
 * @since 11/7/16 11:46 AM
 */

@Controller
@RequestMapping("/")
@SessionAttributes
public class AuthenticationController {


    @Autowired
    private LoginFormValidator loginFormValidator;

    @InitBinder
    private void loginValidator(WebDataBinder binder){
        binder.addValidators(loginFormValidator);
    }

    @PersistenceContext
    EntityManager entityManager;

    @RequestMapping("/")
    public String entry(){
        return "redirect:/auth/login";
    }

    @RequestMapping(value = "/auth/login", method = RequestMethod.GET)
    public String login(Model model){
        User user = new User();
//        user.setEmail("RAYED@GMAIL.COM");
//        user.setPassword("rayedbinwahed");
        model.addAttribute(user);
        return "login";
    }

    @RequestMapping(value = "/auth/signup", method = RequestMethod.GET)
    public String signup(){
        return "signup";
    }

//    @InitBinder()
    @RequestMapping(value = "/auth/verify", method = RequestMethod.POST)
    public String verify(@Validated User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "login";
        }
        return "adminHomePage";
    }

    @RequestMapping(value = "/admin/homepage")
    public String adminpage(){
        return "adminHomePage";
    }

    @RequestMapping(value = "/usr/homepage")
    public String homepage(){
        return "userHomePage";
    }

}
