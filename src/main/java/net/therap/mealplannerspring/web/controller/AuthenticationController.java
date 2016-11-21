package net.therap.mealplannerspring.web.controller;

import net.therap.mealplannerspring.domain.User;
import net.therap.mealplannerspring.service.UserService;
import net.therap.mealplannerspring.web.validator.LoginFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author rayed
 * @since 11/7/16 11:46 AM
 */

@Controller
@RequestMapping("/")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginFormValidator loginFormValidator;

    @InitBinder
    private void loginValidator(WebDataBinder binder) {
        binder.addValidators(loginFormValidator);
    }

    @RequestMapping("/")
    public String entry() {
        return "redirect:/auth/login";
    }

    @RequestMapping(value = "/auth/login", method = RequestMethod.GET)
    public String login(Model model) {
        User user = new User();
        model.addAttribute(user);
        return "login";
    }

    @RequestMapping(value = "/auth/signup", method = RequestMethod.GET)
    public String signup() {
        return "signup";
    }

    @RequestMapping(value = "/auth/verify", method = RequestMethod.POST)
    public String verify(@Validated User user, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        User userByEmail = null;
        userByEmail = userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
        if (userByEmail != null){
            session.setAttribute("email", user.getEmail());
            if (user.getEmail().equals("admin@gmail.com")){
                return "redirect:/admin/homepage";
            }
            return "redirect:/user/homepage";
        }
        return "login";
    }

    @RequestMapping(value = "/admin/homepage")
    public String adminpage() {
        return "adminHomePage";
    }

    @RequestMapping(value = "/user/homepage", method = RequestMethod.GET)
    public String userpage(){
        return "userHomePage";
    }
}
