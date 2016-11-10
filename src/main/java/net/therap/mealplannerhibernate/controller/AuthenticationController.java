package net.therap.mealplannerhibernate.controller;

import net.therap.mealplannerhibernate.entity.User;
import net.therap.mealplannerhibernate.service.UserManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author rayed
 * @since 11/7/16 11:46 AM
 */

@Controller
@RequestMapping("/")
@SessionAttributes
public class AuthenticationController {

    @RequestMapping("/")
    public String entry(){
        return "redirect:/auth/login";
    }

    @RequestMapping(value = "/auth/login", method = RequestMethod.GET)
    public String login(Model model){
        return "login";
    }

    @RequestMapping(value = "/auth/signup", method = RequestMethod.GET)
    public String signup(){
        return "signup";
    }

    @RequestMapping(value = "/auth/verify", method = RequestMethod.POST)
    public String verify(@RequestParam HttpServletRequest req, HttpServletResponse resp){
        String inputEmail = req.getParameter("inputEmail");
        String inputPassword = req.getParameter("inputPassword");
        UserManager userManager = new UserManager();
        User user = userManager.getUser(inputEmail, inputPassword);
        if ("admin@gmail.com".equals(user.getEmail()) && user.getPassword().equals("admin")){
            HttpSession session = req.getSession();
            session.setAttribute("inputEmail", inputEmail);
            return "redirect:/admin/homepage";
        } else if (user != null){
            HttpSession session = req.getSession();
            session.setAttribute("inputEmail", inputEmail);
            return "redirect:/usr/homepage";
        } else {
          return "loginerror";
        }
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
