package com.airline.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {

    @GetMapping(value = {"/","/home"})
    public ModelAndView init() {
        return new ModelAndView("index");
    }
}
