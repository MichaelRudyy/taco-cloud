package com.mcrudyy.tacocloud.controller;

import com.mcrudyy.tacocloud.data.Ingredient;
import com.mcrudyy.tacocloud.data.TacoDesign;
import com.mcrudyy.tacocloud.data.Ingredient.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
public class DesignController {

    private final Logger log = LoggerFactory.getLogger(DesignController.class);

    @GetMapping
    public java.lang.String getDesign(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
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
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        log.info("Add ingradients by type in Model");

        model.addAttribute("design", new TacoDesign());

        log.info("Generate design.html with " + model.toString());

        return "design";
    }

    @PostMapping
    public String submitTacoDesign(@Valid @ModelAttribute("design") TacoDesign design, Errors errors) {

        if (errors.hasErrors()) {
            List<FieldError> fieldErrors = errors.getFieldErrors();
            for (FieldError e : fieldErrors) {
                log.info("" + e.getField());
            }
            return "design";
        }


        log.info("Get TacoDesign: " + design.toString());
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> list, Ingredient.Type type) {
        return list
                .stream()
                .filter(p -> p.getType() == type)
                .collect(Collectors.toList());
    }
}
