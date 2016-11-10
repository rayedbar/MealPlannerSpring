package net.therap.mealplannerhibernate.controller;

import com.google.gson.Gson;
import net.therap.mealplannerhibernate.entity.User;
import net.therap.mealplannerhibernate.service.UserManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author rayed
 * @since 11/7/16 4:38 PM
 */

@Controller
public class UserController {

    @ResponseBody
    @RequestMapping("/usr/get")
    public String getUser(HttpServletRequest request, HttpServletResponse response){
        String user = (String) request.getSession().getAttribute("inputEmail");
        response.setCharacterEncoding("UTF-8");
        return user;
    }

    @RequestMapping(value = "/usr/view", produces = "application/json")
    @ResponseBody
    public String view(){
        UserManager userManager = new UserManager();
        List<User> userList = userManager.getUserList();
        String json = new Gson().toJson(userList);
        return json;
    }

    @RequestMapping("/usr/delete")
    public String delete(@RequestParam("userId") int userId){
        UserManager userManager = new UserManager();
        userManager.deleteUser(userId);
        return "adminHomePage";
    }
}