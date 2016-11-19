package net.therap.mealplannerspring.web.controller;

import net.therap.mealplannerspring.domain.User;
import net.therap.mealplannerspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") int userId) {
        userService.delete(userId);
        return "redirect:/user/view";
    }
}