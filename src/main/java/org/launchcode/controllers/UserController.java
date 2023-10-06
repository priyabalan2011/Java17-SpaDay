package org.launchcode.controllers;

import org.launchcode.data.UserData;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(Model model){
        model.addAttribute("users", UserData.getAll());
        return "user/add";
    }
    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User newuser, String verify) {
// add form submission handling code here
        if(newuser.getPassword().equals(verify)) {
            UserData.add(newuser);
            return "user/index";
        }
        else {
            model.addAttribute("error","Please check both passwords are incorrect!");
            model.addAttribute("username",newuser.getUsername());
            model.addAttribute("email",newuser.getEmail());
            return "user/add";
        }
    }
}
