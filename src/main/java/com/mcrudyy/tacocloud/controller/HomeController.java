package com.mcrudyy.tacocloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/","/home"})
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(HomeController.class);

    @GetMapping
    public String getHome(){
        log.info("Load home.html");
        return "home";
    }
}
