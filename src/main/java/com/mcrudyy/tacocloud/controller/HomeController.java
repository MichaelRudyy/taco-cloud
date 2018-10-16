package com.mcrudyy.tacocloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping(value = {"/","/home"})
public class HomeController {

    @GetMapping
    public String getHome(){
        log.info("Load home.html");
        return "home";
    }
}
