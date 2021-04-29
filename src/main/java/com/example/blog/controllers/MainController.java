package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    //public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    public String home(Model model) {
        String title = "Главная страница";
        model.addAttribute("title", title);
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        String title = "Страница про нас";
        model.addAttribute("title", title);
        return "about";
    }

}
