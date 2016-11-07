package net.therap.mealplannerhibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author rayed
 * @since 11/7/16 4:38 PM
 */

@Controller()
@RequestMapping("/usr")
public class UserController {

    @RequestMapping(value = "/homepage", method = RequestMethod.POST)
    public String homepage(){

        return "HomePage";
    }

}
//TODO FILTER 