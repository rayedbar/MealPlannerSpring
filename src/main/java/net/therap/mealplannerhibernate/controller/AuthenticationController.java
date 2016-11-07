package net.therap.mealplannerhibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author rayed
 * @since 11/7/16 11:46 AM
 */

@Controller
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model){

        return "login";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(){

        return "signup";
    }

}
