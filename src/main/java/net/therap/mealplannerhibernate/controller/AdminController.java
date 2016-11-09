package net.therap.mealplannerhibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author rayed
 * @since 11/8/16 1:17 PM
 */

@Controller
public class AdminController {

    @RequestMapping(value = "/admin/homepage")
    public String adminpage(){
        return "adminHomePage";
    }


}
