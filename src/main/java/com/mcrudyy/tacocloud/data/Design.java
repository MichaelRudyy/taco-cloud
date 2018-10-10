package com.mcrudyy.tacocloud.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class Design {
    @NotNull
    @Size(min=5, message = "Must be longer then 5")
    private String name;

    @Size(min = 1, message = "Must be bigger then 1 ingradient")
    private List<Ingredient> ingradientList;

    public Design(String name,
                  List<Ingredient> ingradientList) {
        this.name = name;
        this.ingradientList = ingradientList;
    }

    public Design() {
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngradientList() {
        return ingradientList;
    }
}
