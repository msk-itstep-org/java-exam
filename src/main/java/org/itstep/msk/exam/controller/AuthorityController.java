package org.itstep.msk.exam.controller;

import org.itstep.msk.exam.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorityController {


    @RequestMapping("/login")
    public String login(Model model, @ModelAttribute User user){
        //model.addAttribute(user);
        return "login";
    }
}
