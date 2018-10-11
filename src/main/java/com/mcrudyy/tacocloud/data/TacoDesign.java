package com.mcrudyy.tacocloud.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class TacoDesign {
    @NotNull
    @Size(min = 5, message = "Must be longer then 5")
    private String name;

    @Size(min = 1, message = "Must be bigger then 1 ingradient")
    private List<String> ingredients;

    public TacoDesign(String name,
                      List<String> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public TacoDesign() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public java.lang.String toString() {
        return "TacoDesign{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
