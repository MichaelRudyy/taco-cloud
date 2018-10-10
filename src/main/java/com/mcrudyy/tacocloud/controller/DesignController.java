package com.mcrudyy.tacocloud.controller;

import com.mcrudyy.tacocloud.data.Design;
import com.mcrudyy.tacocloud.data.Ingredient;
import com.mcrudyy.tacocloud.data.Ingredient.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
public class DesignController {

    private final Logger log = LoggerFactory.getLogger(DesignController.class);

    @GetMapping
    public String getDesign(Model model) {
        List<Ingredient> ingradients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
        );

        Type[] types = Type.values();

        for (Type type : types) {
            model.addAttribute(types.toString().toLowerCase(),
                    filterByType(ingradients, type));
        }

        model.addAttribute("design",new Design());
        log.info("Add ingradients by type in Model");
        log.info("Generate Design");
        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> list, Ingredient.Type type) {
        return list
                .stream()
                .filter(p -> p.getType() == type)
                .collect(Collectors.toList());
    }
}
