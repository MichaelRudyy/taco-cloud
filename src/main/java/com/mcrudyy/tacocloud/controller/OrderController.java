package com.mcrudyy.tacocloud.controller;

import com.mcrudyy.tacocloud.data.Order;
import com.mcrudyy.tacocloud.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;

    @Autowired
    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String getCurrentOrder(Model model){
        //model.addAttribute("order",new Order());  Ибо теперь order генериться раньше
        return "orderForm";
    }

    @PostMapping
    public String submitOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus){
        if(errors.hasErrors()){
            for (FieldError error:errors.getFieldErrors()) {
                log.info("Order error: " + error);
            }
            return "orderForm";
        }

        orderRepo.save(order);
        sessionStatus.setComplete();
        log.info("Order submiter: " + order );
        return "home";
    }
}
