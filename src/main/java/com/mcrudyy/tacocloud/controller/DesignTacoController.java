package com.mcrudyy.tacocloud.controller;

import com.mcrudyy.tacocloud.data.Ingredient;
import com.mcrudyy.tacocloud.data.Taco;
import com.mcrudyy.tacocloud.data.Ingredient.Type;
import com.mcrudyy.tacocloud.repository.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order") // TODO WTF?
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @ModelAttribute
    public void setIngredients(Model model) {
/*        List<Ingredient> ingredients = Arrays.asList(
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
        );*/

        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(c->ingredients.add(c));

        Type[] types = Type.values();

        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @GetMapping
    public String getDesign(Model model) {
        log.info("Add ingredients by type in Model");
        model.addAttribute("design", new Taco());
        log.info("Generate design.html with " + model.toString());

        return "design";
    }

    // TODO Нужно придумать как передавать дизайн тако
    @PostMapping
    public String submitTacoDesign(@Valid @ModelAttribute("design") Taco design, Errors errors) {
        if (errors.hasErrors()) {
            List<FieldError> fieldErrors = errors.getFieldErrors();
            for (FieldError e : fieldErrors) {
                log.info("Error Have been fount in design's " + e.getField());
            }
            return "design";
        }

        log.info("Get Taco: " + design.toString());
        return "redirect:/orders/current"; // redirect to the page without changing URL
    }

    private List<Ingredient> filterByType(List<Ingredient> list, Ingredient.Type type) {
        return list
                .stream()
                .filter(p -> p.getType() == type)
                .collect(Collectors.toList());
    }
}
