package net.therap.mealplannerhibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author rayed
 * @since 11/7/16 4:38 PM
 */

@Controller()
public class UserController {

    @RequestMapping(value = "/usr/homepage")
    public String homepage(){

        return "HomePage";
    }

    @ResponseBody
    @RequestMapping("/usr/get")
    public String getUser(HttpServletRequest request, HttpServletResponse response){
        String user = (String) request.getSession().getAttribute("inputEmail");

        response.setCharacterEncoding("UTF-8");
        //response.setContentType("text");
        return user;
    }
}