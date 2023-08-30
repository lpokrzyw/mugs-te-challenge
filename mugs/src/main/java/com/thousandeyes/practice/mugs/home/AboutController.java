package com.thousandeyes.practice.mugs.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(path = "/about")
@SessionAttributes("order")
public class AboutController {

    @GetMapping
    public String showAboutPage() {
        return "about";
    }
}
