package com.mcrudyy.tacocloud.controller;

import com.mcrudyy.tacocloud.data.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrderController {
    Logger log = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/current")
    public String getCurrentOrder(Model model){
        model.addAttribute("order",new Order());
        return "orderForm";
    }

    @PostMapping
    public String submitOrder(@Valid Order order, Errors errors){
        if(errors.hasErrors()){
            for (FieldError error:errors.getFieldErrors()) {
                log.info("Order error: " + error);
            }
            return "orderForm";
        }
        log.info("Order submiter: " + order );
        return "home";
    }
}
