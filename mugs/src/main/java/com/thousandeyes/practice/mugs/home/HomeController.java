package com.thousandeyes.practice.mugs.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(path = "/home")
@SessionAttributes("order")
public class HomeController {
    @GetMapping
    public String showHomePage() {
        return "home";
    }
}