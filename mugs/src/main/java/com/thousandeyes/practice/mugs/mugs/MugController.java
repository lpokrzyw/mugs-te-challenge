package com.thousandeyes.practice.mugs.mugs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/mugs")
@SessionAttributes("order")
public class MugController {
    @GetMapping
    public String showMugsPage() {
        return "mugs";
    }
}
