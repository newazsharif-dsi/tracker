package com.activity.tracker.user.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController extends BaseController{

    @GetMapping("/home")
    public String home(ModelMap model) {
        model.addAttribute("Hello", "Newaz");
        return route( model, "user/home"); //view
    }

    @GetMapping("/")
    public String redirecThome(Model model) {

        return "redirect:/home"; //view
    }
}
