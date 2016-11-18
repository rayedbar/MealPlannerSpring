package net.therap.mealplannerspring.web.controller;

import net.therap.mealplannerspring.domain.User;
import net.therap.mealplannerspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(Model model) {
        List<User> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "viewUserPage";
    }

    @ResponseBody
    @RequestMapping("/get")
    public String getUser(HttpServletRequest request, HttpServletResponse response) {
        String user = (String) request.getSession().getAttribute("inputEmail");
        response.setCharacterEncoding("UTF-8");
        return user;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("userId") int userId) {
        return "adminHomePage";
    }
}