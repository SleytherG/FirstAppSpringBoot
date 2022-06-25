package com.cloudcomputing.com.web.app.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String home() {
        return "redirect:/app/index";
//        return "forward:/app/index";
    }
}
